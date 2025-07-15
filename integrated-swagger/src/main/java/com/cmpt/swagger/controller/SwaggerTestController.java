package com.cmpt.swagger.controller;

import com.cmpt.swagger.vo.request.HelloSwaggerRequest;
import com.cmpt.swagger.vo.response.HelloSwaggerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 控制器
 * @ClassName SwaggerTestController
 * @Author wang jinglei
 * @Date 2025/7/15
 * @Version 1.0.0
 */
@Api(tags = "swagger文档测试")
@RestController
@RequestMapping("/api/test")
public class SwaggerTestController {

    @ApiOperation("第一个接口文档")
    @PostMapping("hello")
    public HelloSwaggerResponse hello(@RequestBody HelloSwaggerRequest request) {
        return new HelloSwaggerResponse();
    }
}
