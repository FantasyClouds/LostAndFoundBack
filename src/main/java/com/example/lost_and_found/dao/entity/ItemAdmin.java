
package com.example.lost_and_found.dao.entity;

import com.baomidou.mybatisplus.annotation.*;

/**
 * 失物管理员
 */
@TableName("item_admin")
public class ItemAdmin {

    // 内部id，自动生成
    @TableId(type = IdType.AUTO)
    private Long lost_admin_internal_id;

    // id，用于查找（非空）
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private Long lost_admin_id;

    // 名字，用于登陆（非空）
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String lost_admin_name;

    // 密码（非空）
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String lost_admin_password;

    public ItemAdmin() {}

    public ItemAdmin(Long lost_admin_id, String lost_admin_name, String lost_admin_password) {
        this.lost_admin_id = lost_admin_id;
        this.lost_admin_name = lost_admin_name;
        this.lost_admin_password = lost_admin_password;
    }


    /**
     * 内部id，自动生成
     */
    public Long getLost_admin_internal_id() {
        return lost_admin_internal_id;
    }
    /**
     * 内部id，自动生成
     */
    public void setLost_admin_internal_id(Long lost_admin_internal_id) {
        this.lost_admin_internal_id = lost_admin_internal_id;
    }
    /**
     * id，用于查找（非空）
     */
    public Long getLost_admin_id() {
        return lost_admin_id;
    }
    /**
     * id，用于查找（非空）
     */
    public void setLost_admin_id(Long lost_admin_id) {
        this.lost_admin_id = lost_admin_id;
    }
    /**
     * 名字，用于登陆（非空）
     */
    public String getLost_admin_name() {
        return lost_admin_name;
    }
    /**
     * 名字，用于登陆（非空）
     */
    public void setLost_admin_name(String lost_admin_name) {
        this.lost_admin_name = lost_admin_name;
    }
    /**
     * 密码（非空）
     */
    public String getLost_admin_password() {
        return lost_admin_password;
    }
    /**
     * 密码（非空）
     */
    public void setLost_admin_password(String lost_admin_password) {
        this.lost_admin_password = lost_admin_password;
    }

    @Override
    public String toString() {
        return "ItemAdmin{" +
                "lost_admin_internal_id=" + lost_admin_internal_id +
                ", lost_admin_id=" + lost_admin_id +
                ", lost_admin_name='" + lost_admin_name + '\'' +
                ", lost_admin_password='" + lost_admin_password + '\'' +
                '}';
    }
}
;