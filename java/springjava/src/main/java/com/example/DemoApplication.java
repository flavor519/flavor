package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;

// 扫描你的 Mapper 接口（必须加，否则 MyBatis 找不到 mapper）
@SpringBootApplication(exclude = {R2dbcAutoConfiguration.class})
@MapperScan("com.example.mapper")
public class DemoApplication {

    // Spring Boot 启动入口 main 方法
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}