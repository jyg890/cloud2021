package com.maxi.springcloud.service;

import com.maxi.springcloud.entity.CommonResult;
import com.maxi.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author JYG
 * @description
 * @create 2021−02-03 4:34 下午
 */
@Component  //希望能被扫描到
@FeignClient("CLOUD-PAYMENT-SERVICE") //声明调用的服务名 配合主启动类上开启来使用
public interface PaymentFeignService {

    //测试结果为需要写上全路径名 如果写 /get/{id} 在被调用的controller上类上有requestMapping路径 也要写全路径名不然会报404错误
    @GetMapping("/payment/get/{id}")
    CommonResult queryById(@PathVariable("id") Long id);

    //插入
    @PostMapping("/payment/create")
    CommonResult create(@RequestBody Payment payment);

    //测试超时等待接口
    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeout();
}
