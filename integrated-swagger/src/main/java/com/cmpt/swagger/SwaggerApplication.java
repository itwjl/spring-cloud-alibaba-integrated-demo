package com.cmpt.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @Description 启动类
 * @ClassName SwaggerApplication
 * @Author wang jinglei
 * @Date 2025/7/15
 * @Version 1.0.0
 */
@SpringBootApplication
public class SwaggerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class, args);
    }
}
