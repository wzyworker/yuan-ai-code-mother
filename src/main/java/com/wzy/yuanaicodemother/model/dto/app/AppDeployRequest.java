package com.wzy.yuanaicodemother.model.dto.app;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: [wzyWorker]
 * @Date: 2025/10/28 0:11
 * 应用部署请求
 */
@Data
public class AppDeployRequest implements Serializable {

    /**
     * 应用 ID
     */
    private Long appId;

    private static final long serialVersionUID = 1L;
}
