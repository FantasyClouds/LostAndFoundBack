package com.example.lost_and_found.util;

import org.springframework.http.HttpStatus;

import lombok.Data;
/**
 * 前后端交互的响应类，包括状态码、消息、数据。
 * 
 * 修改说明：
 * 移除了@Repository注解（响应类不需要此注解）
 * 增加了@Data注解，自动为所有字段生成 getter、setter 等方法，方便设置和获取响应数据
 **/
@Data
public class Response<T> {
    public HttpStatus status;
    public String msg;
    public T data;
}