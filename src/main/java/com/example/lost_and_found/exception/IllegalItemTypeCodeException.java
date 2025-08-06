package com.example.lost_and_found.exception;

/**
 * 通过非法枚举数字获取ItemType时抛出此异常
 */
public class IllegalItemTypeCodeException extends RuntimeException {
    public IllegalItemTypeCodeException() {
        super("非法的ItemType代码");
    }
}
