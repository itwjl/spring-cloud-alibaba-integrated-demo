package com.cmpt.openfeign.feignclient;

import com.cmpt.openfeign.config.LoadBalancedConfig;
import com.cmpt.openfeign.feignclient.impl.MybatisPlusFeignClientImpl;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Description TODO
 * @ClassName MybatisPlusFeignClient
 * @Author wang jinglei
 * @Date 2025/7/15
 * @Version 1.0.0
 */
@FeignClient(value = "mybatisplus-server", path = "/mybatisplus", fallback = MybatisPlusFeignClientImpl.class)
@LoadBalancerClient(name = "mybatisplus-server", configuration = LoadBalancedConfig.class)
public interface MybatisPlusFeignClient {

    @PostMapping("/api/user/save")
    String addUser();
}
