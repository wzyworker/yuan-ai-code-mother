package com.wzy.yuanaicodemother.core;

import com.wzy.yuanaicodemother.model.enums.CodeGenTypeEnum;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: [wzyWorker]
 * @Date: 2025/10/6 20:14
 */
@SpringBootTest
class AiCodeGeneratorFacadeTest {

    @Resource
    private AiCodeGeneratorFacade aiCodeGeneratorFacade;

    @Test
    void generateAndSaveCode() {
        File file = aiCodeGeneratorFacade.generateAndSaveCode("生成一个登录页面，总共不超过20行", CodeGenTypeEnum.MULTI_FILE);
        Assertions.assertNotNull(file);
    }

    @Test
    void generateAndSaveCodeStream() {
        Flux<String> codeStream = aiCodeGeneratorFacade.generateAndSaveCodeStream("生成一个登录页面，总共不超过20行", CodeGenTypeEnum.HTML);
        // 阻塞等待所有数据返回
        List<String> result = codeStream.collectList().block();
        Assertions.assertNotNull(result);
        // 拼接完整内容
        String completeString = String.join("", result);
        Assertions.assertNotNull(completeString);
    }
}