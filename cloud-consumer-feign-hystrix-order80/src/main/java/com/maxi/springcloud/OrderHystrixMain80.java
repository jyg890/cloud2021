package com.maxi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author JYG
 * @description
 * @create 2021−02-04 3:40 下午
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix //消费端主启动类添加hystrix注解
public class OrderHystrixMain80 {
    public static void main(String[] args){
        SpringApplication.run(OrderHystrixMain80.class,args);
    }
}
