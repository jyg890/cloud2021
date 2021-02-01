package com.maxi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author JYG
 * @description
 * @create 2021−02-01 11:09 上午
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002 {
public static void main(String[] args){
    SpringApplication.run(PaymentMain8002.class,args);     
}
}
