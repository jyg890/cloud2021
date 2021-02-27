package com.maxi.springcloud.alibaba.controller;

import com.maxi.springcloud.alibaba.domain.CommonResult;
import com.maxi.springcloud.alibaba.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JYG
 * @description
 * @create 2021−02-26 3:26 下午
 */
@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;

    /**
     * 扣减库存
     * @RequestMapping的请求方式
     * （1）如果方法上的@RequestMapping注解没有设置method属性，则get和post请求默认都可以访问。
     * （2）如果方法上的@RequestMapping注解设置了method属性，则只能是相应的请求方式可以访问。
     */
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功！");
    }
}
