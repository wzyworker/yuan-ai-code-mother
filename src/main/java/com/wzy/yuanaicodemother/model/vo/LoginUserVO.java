package com.wzy.yuanaicodemother.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wzy
 * @date 2025年09月19日 23:42
 * 脱敏后的用户信息
 */
@Data
public class LoginUserVO implements Serializable {

    private static final long serialVersionUID = 87837717764348436L;

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户简介
     */
    private String userProfile;

    /**
     * 用户角色
     */
    private String userRole;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

}
