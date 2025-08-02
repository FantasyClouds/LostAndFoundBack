package com.example.lost_and_found.exception;
/**
 * 注册时，用户密码不合法时抛出此异常。
 * 抛出此异常需要传入一个字符串信息。
 */
public class UserPasswordIllegalException extends RuntimeException {
    public UserPasswordIllegalException(String message) {
        super(message);
    }
}
