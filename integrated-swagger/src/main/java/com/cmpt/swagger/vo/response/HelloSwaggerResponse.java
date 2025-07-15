package com.cmpt.swagger.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description TODO
 * @ClassName HelloSwaggerResponse
 * @Author wang jinglei
 * @Date 2025/7/15
 * @Version 1.0.0
 */
@Data
@ApiModel
public class HelloSwaggerResponse {

    @ApiModelProperty(value = "消息")
    private String message;
}
