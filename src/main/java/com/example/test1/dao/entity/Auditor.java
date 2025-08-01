
package com.example.test1.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("auditor")
public class Auditor {

    @TableId(type = IdType.AUTO)
    private Long auditor_internal_id;

    @TableField
    private Long auditor_id;

    @TableField
    private String auditor_name;

    @TableField
    private String auditor_password;

    public Auditor() {}

    public Auditor(Long auditor_internal_id, Long auditor_id, String auditor_name, String auditor_password) {
        this.auditor_internal_id = auditor_internal_id;
        this.auditor_id = auditor_id;
        this.auditor_name = auditor_name;
        this.auditor_password = auditor_password;
    }

    public Long getAuditor_internal_id() {
        return auditor_internal_id;
    }

    public void setAuditor_internal_id(Long auditor_internal_id) {
        this.auditor_internal_id = auditor_internal_id;
    }

    public Long getAuditor_id() {
        return auditor_id;
    }

    public void setAuditor_id(Long auditor_id) {
        this.auditor_id = auditor_id;
    }

    public String getAuditor_name() {
        return auditor_name;
    }

    public void setAuditor_name(String auditor_name) {
        this.auditor_name = auditor_name;
    }

    public String getAuditor_password() {
        return auditor_password;
    }

    public void setAuditor_password(String auditor_password) {
        this.auditor_password = auditor_password;
    }

    @Override
    public String toString() {
        return "Auditor{" +
                "auditor_internal_id=" + auditor_internal_id +
                ", auditor_id=" + auditor_id +
                ", auditor_name='" + auditor_name + '\'' +
                ", auditor_password='" + auditor_password + '\'' +
                '}';
    }
}
;