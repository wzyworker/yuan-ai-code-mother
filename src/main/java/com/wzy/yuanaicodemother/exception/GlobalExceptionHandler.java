package com.wzy.yuanaicodemother.exception;

import com.wzy.yuanaicodemother.common.BaseResponse;
import com.wzy.yuanaicodemother.common.ResultUtils;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wzy
 * @date 2025年09月06日 22:47
 */
@Hidden
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 在任何地方抛出 BusinessException 都会被这个方法捕获
    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> businessExceptionHandler(BusinessException e) {
        log.error("BusinessException: ", e);
        return ResultUtils.error(e.getCode(), e.getMessage());
    }

    // 在任何地方抛出 RuntimeException 都会被这个方法捕获
    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<?> businessExceptionHandler(RuntimeException e) {
        log.error("RuntimeException: ", e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "系统错误");
    }
}
