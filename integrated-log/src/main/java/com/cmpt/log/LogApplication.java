package com.cmpt.log;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description 日志测试启动类
 * @ClassName LogApplication
 * @Author wang jinglei
 * @Date 2025/7/15
 * @Version 1.0.0
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.cmpt.log.mapper")
public class LogApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class, args);
        log.info("++++++++启动成功+++++++++");
    }
}
