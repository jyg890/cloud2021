package com.maxi.springcloud.controller;

import com.maxi.springcloud.entity.CommonResult;
import com.maxi.springcloud.entity.Payment;
import com.maxi.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author JYG
 * @description
 * @create 2021−02-03 4:36 下午
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        return paymentFeignService.queryById(id);
    }

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult create(Payment payment){ //测试中发现在消费者controller层这里在参数前如果加上 @RequestBody 注解 就会报错 为  ----body missing
        return paymentFeignService.create(payment);
    }

    @GetMapping("consumer/payment/timeout")
    public String feignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }

}
