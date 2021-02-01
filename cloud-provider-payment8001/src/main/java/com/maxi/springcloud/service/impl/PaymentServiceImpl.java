package com.maxi.springcloud.service.impl;

import com.maxi.springcloud.dao.PaymentDao;
import com.maxi.springcloud.entity.Payment;
import com.maxi.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author JYG
 * @description
 * @create 2021−01-30 1:03 下午
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
