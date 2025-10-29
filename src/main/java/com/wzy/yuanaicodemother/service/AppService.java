package com.wzy.yuanaicodemother.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.wzy.yuanaicodemother.model.dto.app.AppQueryRequest;
import com.wzy.yuanaicodemother.model.entity.App;
import com.wzy.yuanaicodemother.model.entity.User;
import com.wzy.yuanaicodemother.model.vo.AppVO;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author wzy
 */
public interface AppService extends IService<App> {

    /**
     * 生成应用代码
     *
     * @param appId     应用 id
     * @param message   提示词
     * @param loginUser 登录用户
     * @return 代码生成结果（流式对象）
     */
    Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    /**
     * 应用部署
     *
     * @param appId     应用 id
     * @param loginUser 登录用户
     * @return 部署结果（url）
     */
    String deployApp(Long appId, User loginUser);

    /**
     * 获取应用封装类
     *
     * @param app 应用
     * @return 应用封装类
     */
    AppVO getAppVO(App app);

    /**
     * 获取应用封装类列表
     *
     * @param appList 应用列表
     * @return 应用封装类列表
     */
    List<AppVO> getAppVOList(List<App> appList);

    /**
     * 构造应用查询条件
     *
     * @param appQueryRequest 应用查询请求
     * @return 查询条件
     */
    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

}
