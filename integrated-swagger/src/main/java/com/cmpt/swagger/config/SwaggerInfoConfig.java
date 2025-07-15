package com.cmpt.swagger.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @ClassName SwaggerInfoConfig
 * @Author wang jinglei
 * @Date 2025/7/15
 * @Version 1.0.0
 */
@Component
@Data
@ConfigurationProperties(prefix = "swagger3")
public class SwaggerInfoConfig {

    /**
     * 项目名称
     */
    private String name;

    /**
     * 版本
     */
    private String version;

    /**
     * 版权年份
     */
    private String copyrightYear;
}
