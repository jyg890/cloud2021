package com.maxi.springcloud.alibaba.controller;

import com.maxi.springcloud.alibaba.domain.CommonResult;
import com.maxi.springcloud.alibaba.domain.Order;
import com.maxi.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author JYG
 * @description
 * @create 2021−02-26 3:37 下午
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
