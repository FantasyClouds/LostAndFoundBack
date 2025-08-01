
package com.example.test1.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("item_admin")
public class ItemAdmin {

    @TableId(type = IdType.AUTO)
    private Long lost_admin_internal_id;

    @TableField
    private Long lost_admin_id;

    @TableField
    private String lost_admin_name;

    @TableField
    private String lost_admin_password;

    public ItemAdmin() {}

    public ItemAdmin(Long lost_admin_internal_id, Long lost_admin_id, String lost_admin_name, String lost_admin_password) {
        this.lost_admin_internal_id = lost_admin_internal_id;
        this.lost_admin_id = lost_admin_id;
        this.lost_admin_name = lost_admin_name;
        this.lost_admin_password = lost_admin_password;
    }

    public Long getLost_admin_internal_id() {
        return lost_admin_internal_id;
    }

    public void setLost_admin_internal_id(Long lost_admin_internal_id) {
        this.lost_admin_internal_id = lost_admin_internal_id;
    }

    public Long getLost_admin_id() {
        return lost_admin_id;
    }

    public void setLost_admin_id(Long lost_admin_id) {
        this.lost_admin_id = lost_admin_id;
    }

    public String getLost_admin_name() {
        return lost_admin_name;
    }

    public void setLost_admin_name(String lost_admin_name) {
        this.lost_admin_name = lost_admin_name;
    }

    public String getLost_admin_password() {
        return lost_admin_password;
    }

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