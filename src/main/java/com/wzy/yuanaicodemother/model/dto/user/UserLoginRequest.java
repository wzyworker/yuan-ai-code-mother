package com.wzy.yuanaicodemother.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wzy
 * @date 2025年09月19日 23:39
 * 用户登录请求类
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 7844252837833563973L;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户密码
     */
    private String userPassword;
}
