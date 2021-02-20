package com.maxi.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JYG
 * @description
 * @create 2021−02-20 2:43 下午
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String ConfigInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return ConfigInfo;
    }
}
