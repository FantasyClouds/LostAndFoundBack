package com.example.test1.util;

import org.springframework.stereotype.Repository;

@Repository
public class Response<T> {
    public int status;
    public String msg;
    public T data;
}
