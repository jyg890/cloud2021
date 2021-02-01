package com.maxi.springcloud.service.impl;

import com.maxi.springcloud.dao.PaymentDao;
import com.maxi.springcloud.entity.Payment;
import com.maxi.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author JYG
 * @description
 * @create 2021−02-01 2:07 下午
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment queryById(Long id) {
        return paymentDao.queryById(id);
    }
}
