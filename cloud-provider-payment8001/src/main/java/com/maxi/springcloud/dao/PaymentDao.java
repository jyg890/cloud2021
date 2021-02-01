package com.maxi.springcloud.dao;

import com.maxi.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author JYG
 * @description
 * @create 2021−01-29 4:39 下午
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment queryById(@Param("id") Long id);

}
