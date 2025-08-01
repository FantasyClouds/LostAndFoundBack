package com.example.lost_and_found.exception;
/**
 * 用户名已存在异常
 * 抛出此异常需要传入一个字符串信息。
 */
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
