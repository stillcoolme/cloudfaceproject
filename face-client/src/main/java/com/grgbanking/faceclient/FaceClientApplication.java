package com.grgbanking.faceclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
// 向服务中心注册
@EnableDiscoveryClient
@EnableFeignClients
public class FaceClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaceClientApplication.class, args);
    }

    @Bean
    // 表明这个restRemplate开启负载均衡的功能
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
