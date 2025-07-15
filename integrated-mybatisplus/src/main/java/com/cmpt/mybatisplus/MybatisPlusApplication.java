package com.cmpt.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description 启动类
 * @ClassName com.cmpt.mybatisplus.MybatisPlusApplication
 * @Author wang jinglei
 * @Date 2025/7/15
 * @Version 1.0.0
 */
@SpringBootApplication
@MapperScan("com.cmpt.mybatisplus.mapper")
public class MybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
        System.out.println("^_^启动成功^_^");
    }
}
