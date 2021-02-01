package com.maxi.springcloud.service;

import com.maxi.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author JYG
 * @description
 * @create 2021−01-30 1:01 下午
 */
public interface PaymentService {

    int create(Payment payment);

    Payment queryById(@Param("id") Long id);
}
