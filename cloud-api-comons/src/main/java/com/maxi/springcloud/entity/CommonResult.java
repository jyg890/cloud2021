package com.maxi.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author JYG
 * @description
 * @create 2021−01-29 4:35 下午
 * 返回信息封装体
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
//T代表传入什么就返回什么 的泛型
public class CommonResult<T>{

    private Integer code;
    private String message;
    private T      data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
