package com.maxi.springcloud.dao;

import com.maxi.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author JYG
 * @description
 * @create 2021−02-01 2:08 下午
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment queryById(@Param("id") Long id);

}
