package com.cmpt.log.controller;

import com.cmpt.log.entity.Log;
import com.cmpt.log.mapper.LogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @ClassName LogController
 * @Author wang jinglei
 * @Date 2025/7/15
 * @Version 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/api/log")
public class LogController {

    @Resource
    private LogMapper logMapper;

    @PostMapping("/save")
    public String save(@RequestBody Log request) {
        log.info("request:{}", request);
        request.setId(System.currentTimeMillis());
        final int insert = logMapper.insert(request);
        log.info("insert:{}", insert);
        return "success";
    }
}
