package com.wzy.yuanaicodemother.aop;

import com.wzy.yuanaicodemother.annotation.AuthCheck;
import com.wzy.yuanaicodemother.exception.BusinessException;
import com.wzy.yuanaicodemother.exception.ErrorCode;
import com.wzy.yuanaicodemother.model.entity.User;
import com.wzy.yuanaicodemother.model.enums.UserRoleEnum;
import com.wzy.yuanaicodemother.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author wzy
 * @date 2025年09月21日 21:27
 * 权限拦截器(切面类)
 */
@Aspect
@Component
public class AuthInterceptor {

    @Resource
    private UserService userService;

    /**
     * 定义切点，只对有AuthCheck注解的方法进行拦截
     *
     * @param joinPoint 切点
     * @param authCheck 权限校验注解
     * @return 切面方法执行结果
     * @throws Throwable 异常
     */
    @Around("@annotation(authCheck)")
    public Object doIntercept(ProceedingJoinPoint joinPoint, AuthCheck authCheck) throws Throwable {
        // 从注解上获取到必须的角色
        String mustRole = authCheck.mustRole();
        // 获取当前登录用户
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        User loginUser = userService.getLoginUser(request);
        // 判断用户是否具有必须的角色
        UserRoleEnum mustRoleEnum = UserRoleEnum.getEnumByValue(mustRole);
        // 不需要权限，直接放行
        if (mustRoleEnum == null) {
            joinPoint.proceed();
        }
        // 需要权限，判断用户是否具有必须的角色
        UserRoleEnum loginUserRoleEnum = UserRoleEnum.getEnumByValue(loginUser.getUserRole());
        // 没有角色直接拒绝
        if (loginUserRoleEnum == null) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        // 判断用户是否具有必须的角色，这里只判断是否有管理员的角色
        if (UserRoleEnum.ADMIN.equals(mustRoleEnum) && !UserRoleEnum.ADMIN.equals(loginUserRoleEnum)) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        // 有权限，放行
        return joinPoint.proceed();
    }
}
