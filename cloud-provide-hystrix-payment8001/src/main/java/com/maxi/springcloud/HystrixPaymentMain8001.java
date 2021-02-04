package com.maxi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author JYG
 * @description
 * @create 2021−02-04 2:21 下午
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker  //开启hystrix
public class HystrixPaymentMain8001 {
    public static void main(String[] args){
        SpringApplication.run(HystrixPaymentMain8001.class,args);     
    }
}
