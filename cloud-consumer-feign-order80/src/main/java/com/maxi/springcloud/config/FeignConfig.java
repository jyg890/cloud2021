package com.maxi.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Configuration;

/**
 * @author JYG
 * @description
 * @create 2021−02-04 10:11 上午
 */
//配置打印日志级别
@Configuration
public class FeignConfig {

    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
