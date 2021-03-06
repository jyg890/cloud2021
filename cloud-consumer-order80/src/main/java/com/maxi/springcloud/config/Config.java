package com.maxi.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author JYG
 * @description
 * @create 2021−01-30 3:22 下午
 */
@Configuration
public class Config {

    @Bean
    //@LoadBalanced    //赋予restTemplate负载均衡能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
