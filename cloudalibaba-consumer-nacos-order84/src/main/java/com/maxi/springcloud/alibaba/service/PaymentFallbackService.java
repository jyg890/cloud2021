package com.maxi.springcloud.alibaba.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author JYG
 * @description  自定义异常降级兜底方法
 * @create 2021−02-25 2:55 下午
 */
@Component
public class PaymentFallbackService implements PaymentService{//

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
