package com.cmpt.openfeign.controller;

import com.cmpt.openfeign.feignclient.MybatisPlusFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @ClassName FeignClientController
 * @Author wang jinglei
 * @Date 2025/7/15
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/api/feign")
public class FeignClientController {

    @Autowired
    private MybatisPlusFeignClient mybatisPlusFeignClient;

    @PostMapping("/feign-client")
    public String feignClient() {
        try {
            return mybatisPlusFeignClient.addUser();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("feignClient error");
        }
        return "feignClient error";
    }
}
