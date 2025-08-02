package com.example.lost_and_found.exception;
/**
 * 注册时，用户名已存在异常
 * 抛出此异常需要传入一个字符串信息。
 */
public class UserNameAlreadyExistsException extends RuntimeException {
    public UserNameAlreadyExistsException(String message) {
        super(message);
    }
}
