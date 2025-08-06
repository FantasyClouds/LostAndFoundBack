package com.example.lost_and_found.exception;

/**
 * 用非法字符串获取Item类型时抛出的异常
 */
public class IllegalItemTypeNameException extends RuntimeException {
    public IllegalItemTypeNameException() {
        super("非法的Item类型名称");
    }
}
