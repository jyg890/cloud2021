package com.maxi.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JYG
 * @description
 * @create 2021−02-03 2:04 下午
 */
@Configuration  //不可放在ComponentScan下能扫描到的包
public class MyselfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule(); //随机
        //com.netflix.loadbalancer.RoundRobinRule  轮询
        //com.netflix.loadbalancer.RetryRule  先轮询 如果获取服务失败则在指定时间内重试
        //WeightedResponseTimeRule  对轮询的扩展 哪个实例 响应速度越快 被选择到的权重就越大
        //BestAvailableRule   会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
        //AvailabilityFilteringRule 先过滤到故障实例  然后选择并发量较小的实例
        //ZoneAvoidanceRule  默认规则  复合判断server所在的区域的性能和server的可用性来选择服务器
    }
}