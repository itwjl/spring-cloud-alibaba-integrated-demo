package com.cmpt.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description 远程过程调用启动类
 * @ClassName OpenfeignApplication
 * @Author wang jinglei
 * @Date 2025/7/15
 * @Version 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient //启动nacos注解
@EnableFeignClients //开启feign的客户端
public class OpenfeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignApplication.class, args);
        System.out.println("^_^启动成功^_^");
    }
}
