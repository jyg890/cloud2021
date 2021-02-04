package com.maxi.springcloud.controller;

import com.maxi.springcloud.entity.CommonResult;
import com.maxi.springcloud.entity.Payment;
import com.maxi.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author JYG
 * @description
 * @create 2021−01-30 1:05 下午
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    //引入接口  import org.springframework.cloud.client.discovery.DiscoveryClient;
    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String servicePort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入数据的ID:\t" + payment.getId());
        log.info("插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功,server.port = " + servicePort, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }

    }

    @GetMapping("/get/{id}")
    public CommonResult queryById(@PathVariable("id") Long id){
        Payment payment = paymentService.queryById(id);
        log.info("***查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询数据成功,server.port = " + servicePort, payment);
        } else {
            return new CommonResult(444, "没有对应记录", null);
        }

    }

    @GetMapping("/discovery")
    public Object discovery(){

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance element : instances) {
            log.info("*******" + element.getServiceId() + element.getHost() + element.getPort() + element.getUri());
        }

        return this.discoveryClient;
    }

    //手写轮询算法测试接口
    @GetMapping("/lb")
    public String getPaymentLB(){
        return servicePort;
    }

    //测试超时等待接口
    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return servicePort;
    }
}
