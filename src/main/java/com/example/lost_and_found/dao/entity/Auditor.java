
package com.example.lost_and_found.dao.entity;

import com.baomidou.mybatisplus.annotation.*;


/**
 * 审核员实体
 */
@TableName("auditor")
public class Auditor {

    // 审核员内部id，自动生成
    @TableId(type = IdType.AUTO)
    private Long auditor_internal_id;

    // 审核员id，用于查找，唯一
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private Long auditor_id;

    // 审核员账号名字，用于登陆
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String auditor_name;

    // 审核员密码
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String auditor_password;

    public Auditor() {}

    public Auditor(Long auditor_internal_id, Long auditor_id, String auditor_name, String auditor_password) {
        this.auditor_internal_id = auditor_internal_id;
        this.auditor_id = auditor_id;
        this.auditor_name = auditor_name;
        this.auditor_password = auditor_password;
    }

    /**
     * 审核员内部id，自动生成
     */
    public Long getAuditor_internal_id() {
        return auditor_internal_id;
    }

    /**
     * 审核员内部id，自动生成
     */
    public void setAuditor_internal_id(Long auditor_internal_id) {
        this.auditor_internal_id = auditor_internal_id;
    }

    /**
     * 审核员id，用于查找，唯一
     */
    public Long getAuditor_id() {
        return auditor_id;
    }

    /**
     * 审核员id，用于查找，唯一
     */
    public void setAuditor_id(Long auditor_id) {
        this.auditor_id = auditor_id;
    }

    /**
     * 审核员账号名字，用于登陆
     */
    public String getAuditor_name() {
        return auditor_name;
    }

    /**
     * 审核员账号名字，用于登陆
     */
    public void setAuditor_name(String auditor_name) {
        this.auditor_name = auditor_name;
    }

    /**
     * 审核员密码
     */
    public String getAuditor_password() {
        return auditor_password;
    }

    /**
     * 审核员密码
     */
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