package com.cmpt.openfeign.config;

import feign.Retryer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class LoadBalancedConfig {
    /**
     * 配置负载均衡策略
     *
     * @param environment
     * @param loadBalancerClientFactory
     * @return ReactorLoadBalancer<ServiceInstance>
     */
    @Bean
    ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
                                                            LoadBalancerClientFactory loadBalancerClientFactory) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        // 轮询负载均衡
        return new RoundRobinLoadBalancer(loadBalancerClientFactory
                .getLazyProvider(name, ServiceInstanceListSupplier.class),
                name);
    }

    /**
     * 请求失败时，默认重试策略(默认重试5次）
     *
     * @return
     * @Param * @param null
     */
    @Bean
    public Retryer feignRetryer() {
        // 每次重试之间等待 500 毫秒。最大等待时间为 1 毫秒。最多尝试 3 次。
        return new Retryer.Default(500, 1, 3);
    }
}
