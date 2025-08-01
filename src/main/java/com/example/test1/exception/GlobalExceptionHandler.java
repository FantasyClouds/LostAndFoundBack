package com.example.test1.exception;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Hidden
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 处理 UserAlreadyExistsException
    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT) // 自动设置 HTTP 409
    public ErrorResponse handleUserExists(UserAlreadyExistsException ex) {
        return new ErrorResponse(ex.getMessage());
    }
    @Data
    @AllArgsConstructor
    public static class ErrorResponse {
        private String message;
    }
}
