package com.maxi.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JYG
 * @description
 * @create 2021−02-05 4:56 下午
 */
//构建路由定位 使目标页面通过网关来访问
@Configuration
public class GatewayConfig {


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_maxi",
                r -> r.path("/guoji").
                        uri("http://news.baidu.com/guoji")).build();

        return routes.build();

    }


    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_maxi2",
                r -> r.path("/guonei").
                        uri("http://news.baidu.com/guonei")).build();

        return routes.build();

    }

}
