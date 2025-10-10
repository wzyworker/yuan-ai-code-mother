package com.wzy.yuanaicodemother.model.dto.app;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: [wzyWorker]
 * @Date: 2025/10/8 22:03
 * 应用创建请求
 */
@Data
public class AppAddRequest implements Serializable {

    /**
     * 应用初始化的 prompt
     */
    private String initPrompt;

    private static final long serialVersionUID = 1L;

}
