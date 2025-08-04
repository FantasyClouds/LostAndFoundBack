package com.example.lost_and_found.exception;
/**
 * 错误使用字符串转换到地点枚举值的异常。
 */
public class IllegalLocationNameException extends RuntimeException {
    public IllegalLocationNameException() {
        super("不存在的地点字符串");
    }
}
