package com.maxi.springcloud.filter;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author JYG
 * @description
 * @create 2021−02-06 2:53 下午
 */
@Component
@Slf4j
//全局过滤器自定义
public class MyFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("**********come in GlobalFilter " + new Date());
        String name = exchange.getRequest().getQueryParams().getFirst("name");
        if(StrUtil.isBlank(name)){
            log.info("******这个用户有问题！******");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);//去往下一个过滤链
    }

    //过滤器执行等级
    @Override
    public int getOrder() {
        return 0;
    }
}
