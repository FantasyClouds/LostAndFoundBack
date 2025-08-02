package com.example.lost_and_found.dao.dto;

import lombok.Data;

/**
 * 用于登录请求dto对象
 * 主要起到安全防护作用
 */
@Data
public class LoginRequest {
    private String account;
    private String password;
    /**
     * 用户账号
     */
    public String getAccount() {
        return account;
    }
    /**
     * 用户账号
     */
    public void setAccount(String account) {
        this.account = account;
    }
    /**
     * 用户密码
     */
    public String getPassword() {
        return password;
    }
    /**
     * 用户密码
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
