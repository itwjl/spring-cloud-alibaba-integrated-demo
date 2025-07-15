package com.cmpt.swagger.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description TODO
 * @ClassName HelloSwaggerRequest
 * @Author wang jinglei
 * @Date 2025/7/15
 * @Version 1.0.0
 */
@Data
@ApiModel
public class HelloSwaggerRequest {

    @ApiModelProperty(value = "名称", required = true)
    private String name;
}
