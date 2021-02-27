package com.maxi.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author JYG
 * @description
 * @create 2021−02-26 3:18 下午
 */
@MapperScan({"com.maxi.springcloud.alibaba.dao"})
@Configuration
public class MybatisConfig {
}
