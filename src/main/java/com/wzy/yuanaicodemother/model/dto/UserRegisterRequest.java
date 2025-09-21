package com.wzy.yuanaicodemother.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wzy
 * @date 2025年09月17日 0:10
 * 用户注册请求类
 */
@Data
public class UserRegisterRequest implements Serializable {
    private static final long serialVersionUID = -3189802922047913976L;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 确认密码
     */
    private String checkPassword;
}
