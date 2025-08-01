
package com.example.lost_and_found.dao.entity;

import com.baomidou.mybatisplus.annotation.*;


/**
 * 应用用户实体类
 *
 */
@TableName("app_user")
public class AppUser {

    @TableId(type = IdType.AUTO)
    private Long user_internal_id;

    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private Long user_id;

    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String user_name;

    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String user_password;

    public AppUser() {
    }

    public AppUser(Long user_id, String user_name, String user_password) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
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

    @Override
    public String toString() {
        return "User{" +
                "user_internal_id=" + user_internal_id +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                '}';
    }
}
;