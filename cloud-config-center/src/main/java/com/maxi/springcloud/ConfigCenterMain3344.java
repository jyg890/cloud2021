package com.maxi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author JYG
 * @description
 * @create 2021−02-14 1:49 下午
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
    public static void main(String[] args){
        SpringApplication.run(ConfigCenterMain3344.class,args);
    }
}
