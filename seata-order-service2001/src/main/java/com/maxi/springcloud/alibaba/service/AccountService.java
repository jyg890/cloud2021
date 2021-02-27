package com.maxi.springcloud.alibaba.service;

import com.maxi.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author JYG
 * @description
 * @create 2021−02-26 2:19 下午
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    //此处需要注意： 》》》》》》测试之后不一定 有可能版本问题
    // 在FeignClient调用的下面接口中，@RequestParam中要有value即@RequestParam(value ="productId") Long productId格式，
    // 不能省略value写成@RequestParam(productId) Long productId这样，
    // 否则会访问的时候报异常feign.FeignException: status 400 reading xxx#xxxx(String); 
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
