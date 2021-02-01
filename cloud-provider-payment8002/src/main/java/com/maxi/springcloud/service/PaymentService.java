package com.maxi.springcloud.service;

import com.maxi.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author JYG
 * @description
 * @create 2021−02-01 2:05 下午
 */
public interface PaymentService {

    int create(Payment payment);

    Payment queryById(@Param("id") Long id);
}
