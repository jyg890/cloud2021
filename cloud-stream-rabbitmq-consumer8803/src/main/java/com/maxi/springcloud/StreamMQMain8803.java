package com.maxi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author JYG
 * @description
 * @create 2021−02-18 5:02 下午
 */
//当搭建两台消息消费者时候 出现两个问题
// 1。消息重复消费   在stream中同一个group中的多个消费者是竞争关系  这样就能够保证消息只能被其中一个消费者消费
// 2。消息的持久化问题  在两个消费者一个在分组一个不在分组中的情况下 消息生产者发送消息 两个消费者重新启动
// 在分组中的消费者上线就接收到了消息 而另外一个消费者出现了消息丢失也就是消息持久化的问题
@SpringBootApplication
public class StreamMQMain8803 {
    public static void main(String[] args){
        SpringApplication.run(StreamMQMain8803.class,args);     
    }
}
