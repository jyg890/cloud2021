package com.maxi.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author JYG
 * @description
 * @create 2021−02-20 2:41 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientMain3377 {
    public static void main(String[] args){
        SpringApplication.run(ConfigClientMain3377.class,args);
    }
}
