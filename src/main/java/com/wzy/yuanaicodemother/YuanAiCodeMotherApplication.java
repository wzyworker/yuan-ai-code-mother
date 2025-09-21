package com.wzy.yuanaicodemother;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wzy.yuanaicodemother.mapper")
public class YuanAiCodeMotherApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuanAiCodeMotherApplication.class, args);
    }

}
