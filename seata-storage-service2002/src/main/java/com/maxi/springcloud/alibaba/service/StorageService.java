package com.maxi.springcloud.alibaba.service;

/**
 * @author JYG
 * @description
 * @create 2021−02-26 3:22 下午
 */
public interface StorageService {
    //扣减库存
    void decrease( Long productId, Integer count);
}
