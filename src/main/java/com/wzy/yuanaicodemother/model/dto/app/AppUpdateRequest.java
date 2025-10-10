package com.wzy.yuanaicodemother.model.dto.app;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: [wzyWorker]
 * @Date: 2025/10/8 22:11
 * 应用更新请求
 */
@Data
public class AppUpdateRequest implements Serializable {

    /**
     * 应用 id
     */
    private Long id;

    /**
     * 应用名称
     */
    private String appName;

    private static final long serialVersionUID = 1L;
}
