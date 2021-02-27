package com.maxi.springcloud.alibaba.dao;

import com.maxi.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author JYG
 * @description
 * @create 2021−02-26 10:59 上午
 */
@Mapper
public interface OrderDao {
    //1 新建订单
    void create(Order order);

    //2 修改订单状态，从零改为1
    //注意：此处要加@Param，而且是ibatis下的包，
    // 我此处就因为倒错包了，错误导入了Feing包下的，
    // 导致了以下异常binding.BindingException: Parameter 'userId' not found. Available parameters
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}

