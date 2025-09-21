package com.wzy.yuanaicodemother.constant;

/**
 * @author wzy
 * @date 2025年09月20日 0:09
 * 用户常量
 * 使用接口定义常量，默认会自动加上final
 */
public interface UserConstant {

    /**
     * 登录状态键
     */
    String USER_LOGIN_STATE = "user_login";

    // region[账号状态]

    /**
     * 默认角色
     */
    String DEFAULT_ROLE = "user";

    /**
     * 管理员角色
     */
    String ADMIN_ROLE = "admin";

    // endregion
}
