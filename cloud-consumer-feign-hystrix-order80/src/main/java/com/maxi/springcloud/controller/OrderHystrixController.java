package com.maxi.springcloud.controller;

import com.maxi.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author JYG
 * @description
 * @create 2021−02-04 3:45 下午
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")  //配置全局兜底的方法  在方法上加上@HystrixCommand 那此类方法出现报错或者别的问题都会进入指定的全局兜底方法
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    //在调用的方法上加上@HystrixCommand注解 fallbackMethod表示为降级  指明降级去往的方法  commandProperties中可指明此方法的限定条件 超过此条件会调用前面指明的兜底方法
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
//    })
    //@HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id)
    {
        int age = 10/0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    /*
     * 功能描述: <br>
     * 〈兜底的方法〉
     * @Author: JYG
     * @Date: 2021/2/4 4:41 下午
     */
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id)
    {
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }

    /**
     * 功能描述: <br>
     * 〈全局的兜底方法  在类上指明该方法的名字〉
     * @Author: JYG
     * @Date: 2021/2/4 5:15 下午
     */
    public String payment_Global_FallbackMethod()
    {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
