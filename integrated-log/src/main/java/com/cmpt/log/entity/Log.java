package com.cmpt.log.entity;

import lombok.Data;

/**
 * @Description TODO
 * @ClassName LogEntity
 * @Author wang jinglei
 * @Date 2025/7/15
 * @Version 1.0.0
 */
@Data
public class Log {

    private Long id;

    private String keyIndex;

    private String logLevel;

    private String application;

    private String contextPath;

    private String request;

    private String response;

    private String traceId;

    private String createTime;

    private String updateTime;

    private Integer deleted;
}
