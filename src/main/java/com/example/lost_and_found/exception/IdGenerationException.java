package com.example.lost_and_found.exception;

/**
 * id生成异常
 */
public class IdGenerationException extends RuntimeException {
    public IdGenerationException(String message) {
        super(message);
    }
}
