package com.cmpt.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description 启动类
 * @ClassName SwaggerApplication
 * @Author wang jinglei
 * @Date 2025/7/15
 * @Version 1.0.0
 */
@SpringBootApplication
public class SwaggerApplication {
    public static void main(String[] args) throws UnknownHostException {
        final ConfigurableApplicationContext context = SpringApplication.run(SwaggerApplication.class, args);
        final ConfigurableEnvironment environment = context.getEnvironment();
        final String port = environment.getProperty("server.port");
        final String ip = InetAddress.getLocalHost().getHostAddress();
        System.out.println("本地接口文档：http://localhost:" + port + "/swagger-ui/index.html");
        System.out.println("接口文档：http://" + ip + ":" + port + "/doc.html");
        System.out.println("^_^启动成功^_^");
    }
}
