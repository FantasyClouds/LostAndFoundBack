package com.example.lost_and_found.dao.dto;

import com.example.lost_and_found.util.College;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 注册请求dto类
 * 主要用于安全
 */
@Data
@Slf4j
public class RegisterRequest {
    private Long id;
    private String name;
    private String password;
    private String real_name;
    private String type;
    private String phone;
    private College college ;
    /**
     * 用户id
     */
    public Long getId() {
        return id;
    }
    /**
     * 用户id
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 用户名
     */
    public String getName() {
        return name;
    }
    /**
     * 用户名
     */
    public void setName(String name) {
        this.name = name;
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
    /**
     * 用户真实姓名
     */
    public String getReal_name() {
        return real_name;
    }
    /**
     * 用户真实姓名
     */
    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }
    /**
     * 用户类型
     */
    public String getType() {
        return type;
    }
    /**
     * 用户类型
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * 用户手机
     */
    public String getPhone() {
        return phone;
    }
    /**
     * 用户手机
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * 用户学院
     */
    public College getCollege() {
        return college;
    }
    /**
     * 用户学院
     */
    public void setCollege(College college) {
        this.college = college;
    }
}
