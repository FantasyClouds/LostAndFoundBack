
package com.example.lost_and_found.dao.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.example.lost_and_found.util.College;


/**
 * 应用用户实体类
 *
 */
@TableName("app_user")
public class AppUser {

    // 内部id，自动生成
    @TableId(type = IdType.AUTO)
    private Long user_internal_id;

    // 用户学号/工号，注册时填写，用于查找
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private Long user_id;

    // 用户名
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String user_name;

    // 用户密码
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String user_password;

    //用户真实姓名
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String user_real_name;

    //用户手机号
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String user_phone;

    //用户学院
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private College user_college;

    public AppUser() {
    }

    public AppUser(Long user_id, String user_name, String user_password,
                   String user_real_name, String user_phone, College user_college) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_real_name = user_real_name;
        this.user_phone = user_phone;
        this.user_college = user_college;
    }

    /**
     * 内部id，自动生成
     */
    public Long getUser_internal_id() {
        return user_internal_id;
    }

    /**
     * 内部id，自动生成
     */
    public void setUser_internal_id(Long user_internal_id) {
        this.user_internal_id = user_internal_id;
    }

    /**
     * 用户id，用于查找，可写代码维护
     */
    public Long getUser_id() {
        return user_id;
    }

    /**
     * 用户id，用于查找，可写代码维护
     */
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    /**
     * 用户名
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * 用户名
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * 用户密码
     */
    public String getUser_password() {
        return user_password;
    }

    /**
     * 用户密码
     */
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
    /**
     * 用户真实姓名
     */
    public String getUser_real_name() {
        return user_real_name;
    }
    /**
     * 用户真实姓名
     */
    public void setUser_real_name(String user_real_name) {
        this.user_real_name = user_real_name;
    }
    /**
     * 用户手机
     */
    public String getUser_phone() {
        return user_phone;
    }
    /**
     * 用户手机
     */
    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
    /**
     * 用户学院
     */
    public College getUser_college() {
        return user_college;
    }
    /**
     * 用户学院
     */
    public void setUser_college(College user_college) {
        this.user_college = user_college;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_internal_id=" + user_internal_id +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_real_name='" + user_real_name + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_college='" + user_college + '\'' +
                '}';
    }
}
;