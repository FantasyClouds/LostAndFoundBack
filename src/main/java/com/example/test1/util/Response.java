package com.example.test1.util;

import org.springframework.stereotype.Repository;

@Repository
public class Response<T> {
    //状态码，200为成功。
    public int status;
    public String msg;
    public T data;
}
