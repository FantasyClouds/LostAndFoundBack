package com.example.lost_and_found.exception;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * 全局异常处理器
 * 用于处理service层抛出的异常，返回至前端。
 */
@Hidden
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理注册时，用户名已存在异常 UserNameAlreadyExistsException
      */
    @ExceptionHandler(UserNameAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT) // 自动设置 HTTP 409
    public ErrorResponse handleUserNameExists(UserNameAlreadyExistsException ex) {
        return new ErrorResponse(ex.getMessage());
    }

    /**
     * 处理注册时，用户ID已存在异常 UserIdNameAlreadyExistsException
     */
    @ExceptionHandler(UserIdAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT) // 自动设置 HTTP 409
    public ErrorResponse handleUserIdExists(UserIdAlreadyExistsException ex) {
        return new ErrorResponse(ex.getMessage());
    }
    /**
     * 处理注册时，用户ID已存在异常 UserIdNameAlreadyExistsException
     */
    @ExceptionHandler(UserPasswordIllegalException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) // 自动设置 HTTP 422
    public ErrorResponse handleUserPasswordIllegal(UserPasswordIllegalException ex) {
        return new ErrorResponse(ex.getMessage());
    }
    /**
     * 处理注册时，用户手机已存在异常 UserIdNameAlreadyExistsException
     */
    @ExceptionHandler(UserPhoneAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT) // 自动设置 HTTP 409
    public ErrorResponse handleUserPasswordIllegal(UserPhoneAlreadyExistException ex) {
        return new ErrorResponse(ex.getMessage());
    }
    /**
     * 登录时，账号不存在异常 UserNotExistException
     */
    @ExceptionHandler(UserNotExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT) // 自动设置 HTTP 409
    public ErrorResponse handleUserPasswordIllegal(UserNotExistException ex) {
        return new ErrorResponse(ex.getMessage());
    }


    /**
     * 自定义错误响应类
     */
    @Data
    @AllArgsConstructor
    public static class ErrorResponse {
        private String message;
    }
}
