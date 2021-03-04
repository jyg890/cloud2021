package com.maxi.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.maxi.springcloud.alibaba.handler.BlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JYG
 * @description
 * @create 2021−02-25 9:46 上午
 */
@RestController
public class RateLimitController {

    //按名称进行限流加自定义的后续处理 在sentinel中添加资源名为注解@SentinelResource中指定的value
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")//blockHandler = "handleException"指定服务降低兜底的方法
    public CommonResult byResource()
    {
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }

    public CommonResult handleException(BlockException exception)
    {
        return new CommonResult(444,exception.getClass().getCanonicalName()+"服务不可用");
    }

    //按照url对资源进行的限流 快速点击的结果  Blocked by Sentinel (flow limiting)
    //有以下问题
    //1 系统默认的降级返回信息没有体现我们的业务需求
    //2 依照目前情况 我们的处理方法有业务方法有耦合在一起 不直观
    //3 每一个业务方法都加一个兜底的 代码膨胀
    //4 全局统一的处理方法没有体现
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")  //@SentinelResource此注解里面的value值为sentinel中配置的资源名
    public CommonResult byUrl()
    {
        return new CommonResult(200,"按url限流测试OK",new Payment(2020L,"serial002"));
    }


    //自定义的限流处理逻辑
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = BlockHandler.class,blockHandler = "handlerException2")
    //blockHandlerClass = BlockHandler.class 指明服务降低兜底的方法所在的类
    //blockHandler = "handlerException2" 指明服务降级兜底的方法是在前面指定类中哪一个方法
    public CommonResult customerBlockHandler(){
        return new CommonResult(200,"按客戶自定义",new Payment(2020L,"serial003"));
    }
}
