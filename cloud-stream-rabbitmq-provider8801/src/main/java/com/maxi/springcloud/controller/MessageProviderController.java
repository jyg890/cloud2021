package com.maxi.springcloud.controller;

import com.maxi.springcloud.service.MessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author JYG
 * @description
 * @create 2021−02-19 9:54 上午
 */
@RestController
public class MessageProviderController {

    @Resource
    private MessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
