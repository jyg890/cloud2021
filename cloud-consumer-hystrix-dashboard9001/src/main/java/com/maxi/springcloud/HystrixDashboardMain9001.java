package com.maxi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author JYG
 * @description
 * @create 2021−02-05 1:58 下午
 */
@SpringBootApplication
@EnableHystrixDashboard //主启动类上增加仪表监控注解
public class HystrixDashboardMain9001 {
    public static void main(String[] args){
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }
}
