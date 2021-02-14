package com.maxi.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JYG
 * @description
 * @create 2021−02-14 2:08 下午
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;


    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        return configInfo;
    }
}
