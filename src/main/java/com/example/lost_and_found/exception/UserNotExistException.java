package com.example.lost_and_found.exception;

/**
 * 登录时，用户不存在，抛出此异常
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException(String message) {
        super(message);
    }
}
