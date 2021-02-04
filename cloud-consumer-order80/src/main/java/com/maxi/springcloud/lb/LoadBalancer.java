package com.maxi.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author JYG
 * @description
 * @create 2021−02-03 2:36 下午
 */
public interface LoadBalancer {

    ServiceInstance serviceInstance(List<ServiceInstance> serviceInstances);
}
