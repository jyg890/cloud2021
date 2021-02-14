package com.maxi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author JYG
 * @description
 * @create 2021−02-14 2:06 下午
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientMain3355 {
    public static void main(String[] args){
        SpringApplication.run(ConfigClientMain3355.class,args);
    }
}
