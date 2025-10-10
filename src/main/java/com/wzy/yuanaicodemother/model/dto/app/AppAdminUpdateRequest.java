package com.wzy.yuanaicodemother.model.dto.app;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: [wzyWorker]
 * @Date: 2025/10/11 0:12
 * 管理员应用更新请求（可以更新更多内容）
 */
@Data
public class AppAdminUpdateRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 应用封面
     */
    private String cover;

    /**
     * 优先级
     */
    private Integer priority;

    private static final long serialVersionUID = 1L;

}
