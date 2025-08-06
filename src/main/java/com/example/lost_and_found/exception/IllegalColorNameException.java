package com.example.lost_and_found.exception;

/**
 * 通过非法字符获取颜色枚举时抛出的异常
 */
public class IllegalColorNameException extends RuntimeException {
    public IllegalColorNameException() {
        super("非法的颜色名称");
    }
}
