package com.maxi.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author JYG
 * @description
 * @create 2021−02-26 3:17 下午
 */
@Configuration
@MapperScan({"com.maxi.springcloud.alibaba.dao"})
public class MybatisConfig {

}
