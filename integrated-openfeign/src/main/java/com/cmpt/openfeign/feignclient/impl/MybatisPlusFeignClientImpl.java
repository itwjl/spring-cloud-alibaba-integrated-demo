package com.cmpt.openfeign.feignclient.impl;

import com.cmpt.openfeign.feignclient.MybatisPlusFeignClient;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @ClassName MybatisPlusFeignClientImpl
 * @Author wang jinglei
 * @Date 2025/7/15
 * @Version 1.0.0
 */
@Service
public class MybatisPlusFeignClientImpl implements MybatisPlusFeignClient {
    @Override
    public String addUser() {
        System.out.println("报错了");
        return "failure";
    }
}
