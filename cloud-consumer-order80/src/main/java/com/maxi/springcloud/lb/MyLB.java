package com.maxi.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author JYG
 * @description
 * @create 2021−02-03 2:38 下午
 */
@Component
public class MyLB implements LoadBalancer {


    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement() {
        int current;
        int next;
        do{
            current = atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1; //超过了范围则从一开始 否则就➕1
        }while (!this.atomicInteger.compareAndSet(current,next));//例如第一次是0 拿到0的地址值去与compareAndSet里面的内存地址值去比较 如果相等就替换 取反之后就是false跳出当前do--while循环  自旋锁实现
        System.out.println("*****第几次访问，次数next: "+next);
        return next;

    }

    //负载均衡算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标  ，每次服务重启动后rest接口计数从1开始。
    @Override
    public ServiceInstance serviceInstance(List<ServiceInstance> serviceInstances) {
        System.out.println("********" + serviceInstances.size());
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
