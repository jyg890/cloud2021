package com.maxi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author JYG
 * @description
 * @create 2021−02-02 4:49 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain80 {
    public static void main(String[] args){
        SpringApplication.run(OrderConsulMain80.class,args);
    }
}
