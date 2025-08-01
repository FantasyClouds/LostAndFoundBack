
package com.example.lost_and_found.util;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
/**
 * 前后端交互的响应类，包括状态码、消息、数据。
 */
@Repository
public class Response<T> {
    public HttpStatus status;
    public String msg;
    public T data;
}
