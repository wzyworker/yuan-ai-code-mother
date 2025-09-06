package com.wzy.yuanaicodemother.controller;

import com.wzy.yuanaicodemother.common.BaseResponse;
import com.wzy.yuanaicodemother.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wzy
 * @date 2025年09月06日 22:06
 */
@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping("/")
    public BaseResponse<String> healthCheck() {
        return ResultUtils.success("OK");
    }
}
