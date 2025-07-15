package com.cmpt.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description 用户表实体类
 * @ClassName User
 * @Author wang jinglei
 * @Date 2025/7/14
 * @Version 1.0.0
 */
@Data
public class User {

    private Long id;

    private String username;

    private String nickname;

    private String password;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer deleted;
}
