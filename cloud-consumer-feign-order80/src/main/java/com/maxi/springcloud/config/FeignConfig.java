package com.maxi.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JYG
 * @description
 * @create 2021−02-04 10:11 上午
 */
//配置打印日志级别
@Configuration
public class FeignConfig {

    @Bean//一定要加注解@bean放入spring容器
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
