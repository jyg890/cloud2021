package com.maxi.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.maxi.springcloud.service.MessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author JYG
 * @description
 * @create 2021−02-19 9:36 上午
 */
@EnableBinding(Source.class) //根据stream架构图先定义推送消息的管道
@Slf4j
public class MessageProviderImpl implements MessageProvider {

    @Resource
    private MessageChannel output;  //发送消息的管道

    @Override
    public String send() {
        String serial = IdUtil.simpleUUID();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("*********serial:" + serial);
        return null;
    }
}
