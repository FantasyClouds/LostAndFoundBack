package com.example.lost_and_found.exception;
/**
 * 用户id已存在异常
 * 抛出此异常需要传入一个字符串信息。
 */
public class UserPhoneAlreadyExistException extends RuntimeException {
    public UserPhoneAlreadyExistException(String message) {
        super(message);
    }
}
