package com.wzy.yuanaicodemother.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wzy
 * @date 2025年09月21日 23:07
 * 用户更新请求
 */
@Data
public class UserUpdateRequest implements Serializable {
    private static final long serialVersionUID = 3873171218461439220L;

    /**
     * id
     */
    private Long id;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 简介
     */
    private String userProfile;

    /**
     * 用户角色：user/admin
     */
    private String userRole;

}
