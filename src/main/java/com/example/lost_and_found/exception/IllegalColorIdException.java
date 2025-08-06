package com.example.lost_and_found.exception;

/**
 * 使用非法的颜色id获取颜色抛出的异常
 */
public class IllegalColorIdException extends RuntimeException {
    public IllegalColorIdException() {
        super("非法的颜色id");
    }
}
