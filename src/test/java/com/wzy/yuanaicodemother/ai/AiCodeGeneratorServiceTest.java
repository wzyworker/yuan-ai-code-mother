package com.wzy.yuanaicodemother.ai;

import com.wzy.yuanaicodemother.ai.model.HtmlCodeResult;
import com.wzy.yuanaicodemother.ai.model.MultiFileCodeResult;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: [wzyworker]
 * @Date: 2025/10/5 16:48
 */
@SpringBootTest
class AiCodeGeneratorServiceTest {

    @Resource
    private AiCodeGeneratorService aiCodeGeneratorService;

    @Test
    void generateHtmlCode() {
        HtmlCodeResult res = aiCodeGeneratorService.generateHtmlCode("做个程序员张三的博客，不超过20行");
        Assertions.assertNotNull(res);
    }

    @Test
    void generateMultiFileCode() {
        MultiFileCodeResult res = aiCodeGeneratorService.generateMultiFileCode("做个程序员张三的留言版，不超过40行");
        Assertions.assertNotNull(res);
    }
}