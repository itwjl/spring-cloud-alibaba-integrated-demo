package com.cmpt.mybatisplus.controller;


import com.alibaba.fastjson.JSONObject;
import com.cmpt.mybatisplus.entity.User;
import com.cmpt.mybatisplus.mapper.UserMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @Description TODO
 * @ClassName UserController
 * @Author wang jinglei
 * @Date 2025/7/14
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @PostMapping("/save")
    public String save() {
        System.out.println(LocalDateTime.now() + "请求添加用户接口");
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setNickname("风气");
        user.setDeleted(0);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
        return JSONObject.toJSONString(user);
    }
}
