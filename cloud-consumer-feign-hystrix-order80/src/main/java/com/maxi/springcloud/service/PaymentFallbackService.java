package com.maxi.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author JYG
 * @description
 * @create 2021−02-05 9:54 上午
 */
@Component //实现类实现服务接口  重写服务降级方法 做到一对一订制服务降级和与业务代码的解耦
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id)
    {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }
}
