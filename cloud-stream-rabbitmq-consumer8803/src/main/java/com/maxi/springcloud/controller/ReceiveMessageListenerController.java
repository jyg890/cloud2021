package com.maxi.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author JYG
 * @description  消息的消费端 接收消息
 *
 * @EnableBinding(Sink.class)代表将已经定义好的Sink接口中的定义好的接收在这个类中开启监听。
 * 在public void input(Message<String> message)方法头上，
 * 加上了@StreamListener(Sink.INPUT)注解，目的是将Sink中的INPUT代表的接收在这个方法上开启监听。
 * 当监听收到消息时，将自动调用public void input(Message<String> message)方法，传入message对象，我们就可以使用这个对象执行任何逻辑。
 * @create 2021−02-19 10:38 上午
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController
{
    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void input(Message<String> message)
    {
        System.out.println("消费者2号,----->接受到的消息: "+message.getPayload()+"\t  port: "+serverPort);
    }
}
