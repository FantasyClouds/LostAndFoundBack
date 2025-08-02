
package com.example.lost_and_found.dao.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.example.lost_and_found.util.ItemColor;
import com.example.lost_and_found.util.ItemType;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDateTime;

/**
 * 寻物启事（已经找到）
 */
@TableName("lost_finished")
public class LostFinished {

    // 内部id，自动生成
    @TableId(type = IdType.AUTO)
    private Long lost_finished_internal_id;

    // id，用于查找（非空）
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private Long lost_finished_id;

    // 名字（非空）
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String lost_finished_name;

    // 种类（非空）
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private ItemType lost_finished_category;

    // 描述
    @TableField
    private String lost_finished_desc;

    // 丢失地点
    @TableField
    private String lost_finished_location;

    // 颜色（非空）
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private ItemColor lost_color;

    // 图片地址
    @TableField
    private String lost_finished_img_url;

    // 丢失时间
    @TableField
    private LocalDateTime lost_finished_lost_time;

    // 发布时间
    @TableField
    private LocalDateTime lost_finished_public_time;

    // 完成时间
    @TableField
    private LocalDateTime lost_finished_finish_time;

    // 评论区
    @TableField(typeHandler = JacksonTypeHandler.class)
    private JsonNode lost_finished_comment;

    // 审核员id
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private Long lost_finished__auditor_id;

    public LostFinished() {
    }

    public LostFinished(Long lost_finished_internal_id, Long lost_finished_id, String lost_finished_name,
                        ItemType lost_finished_category, String lost_finished_desc, String lost_finished_location,
                        ItemColor lost_color, String lost_finished_img_url, LocalDateTime lost_finished_lost_time,
                        LocalDateTime lost_finished_public_time, LocalDateTime lost_finished_finish_time,
                        JsonNode lost_finished_comment, Long lost_finished__auditor_id) {
        this.lost_finished_internal_id = lost_finished_internal_id;
        this.lost_finished_id = lost_finished_id;
        this.lost_finished_name = lost_finished_name;
        this.lost_finished_category = lost_finished_category;
        this.lost_finished_desc = lost_finished_desc;
        this.lost_finished_location = lost_finished_location;
        this.lost_color = lost_color;
        this.lost_finished_img_url = lost_finished_img_url;
        this.lost_finished_lost_time = lost_finished_lost_time;
        this.lost_finished_public_time = lost_finished_public_time;
        this.lost_finished_finish_time = lost_finished_finish_time;
        this.lost_finished_comment = lost_finished_comment;
        this.lost_finished__auditor_id = lost_finished__auditor_id;
    }
    /**
     * 内部id，自动生成
     */
    public Long getLost_finished_internal_id() {
        return lost_finished_internal_id;
    }
    /**
     * 内部id，自动生成
     */
    public void setLost_finished_internal_id(Long lost_finished_internal_id) {
        this.lost_finished_internal_id = lost_finished_internal_id;
    }
    /**
     * id，用于查找（非空）
     */
    public Long getLost_finished_id() {
        return lost_finished_id;
    }
    /**
     * id，用于查找（非空）
     */
    public void setLost_finished_id(Long lost_finished_id) {
        this.lost_finished_id = lost_finished_id;
    }
    /**
     * 名字（非空）
     */
    public String getLost_finished_name() {
        return lost_finished_name;
    }
    /**
     * 名字（非空）
     */
    public void setLost_finished_name(String lost_finished_name) {
        this.lost_finished_name = lost_finished_name;
    }
    /**
     * 种类（非空）
     */
    public ItemType getLost_finished_category() {
        return lost_finished_category;
    }
    /**
     * 种类（非空）
     */
    public void setLost_finished_category(ItemType lost_finished_category) {
        this.lost_finished_category = lost_finished_category;
    }
    /**
     * 描述
     */
    public String getLost_finished_desc() {
        return lost_finished_desc;
    }
    /**
     * 描述
     */
    public void setLost_finished_desc(String lost_finished_desc) {
        this.lost_finished_desc = lost_finished_desc;
    }
    /**
     * 丢失地点
     */
    public String getLost_finished_location() {
        return lost_finished_location;
    }
    /**
     * 丢失地点
     */
    public void setLost_finished_location(String lost_finished_location) {
        this.lost_finished_location = lost_finished_location;
    }
    /**
     * 颜色（非空）
     */
    public ItemColor getLost_color() {
        return lost_color;
    }
    /**
     * 颜色（非空）
     */
    public void setLost_color(ItemColor lost_color) {
        this.lost_color = lost_color;
    }
    /**
     * 图片地址
     */
    public String getLost_finished_img_url() {
        return lost_finished_img_url;
    }
    /**
     * 图片地址
     */
    public void setLost_finished_img_url(String lost_finished_img_url) {
        this.lost_finished_img_url = lost_finished_img_url;
    }
    /**
     * 丢失时间
     */
    public LocalDateTime getLost_finished_lost_time() {
        return lost_finished_lost_time;
    }
    /**
     * 丢失时间
     */
    public void setLost_finished_lost_time(LocalDateTime lost_finished_lost_time) {
        this.lost_finished_lost_time = lost_finished_lost_time;
    }
    /**
     * 发布时间
     */
    public LocalDateTime getLost_finished_public_time() {
        return lost_finished_public_time;
    }
    /**
     * 发布时间
     */
    public void setLost_finished_public_time(LocalDateTime lost_finished_public_time) {
        this.lost_finished_public_time = lost_finished_public_time;
    }
    /**
     * 完成时间
     */
    public LocalDateTime getLost_finished_finish_time() {
        return lost_finished_finish_time;
    }
    /**
     * 完成时间
     */
    public void setLost_finished_finish_time(LocalDateTime lost_finished_finish_time) {
        this.lost_finished_finish_time = lost_finished_finish_time;
    }
    /**
     * 评论区
     */
    public JsonNode getLost_finished_comment() {
        return lost_finished_comment;
    }
    /**
     * 评论区
     */
    public void setLost_finished_comment(JsonNode lost_finished_comment) {
        this.lost_finished_comment = lost_finished_comment;
    }
    /**
     * 审核员id（非空，外键）
     */
    public Long getLost_finished__auditor_id() {
        return lost_finished__auditor_id;
    }
    /**
     * 审核员id（非空，外键）
     */
    public void setLost_finished__auditor_id(Long lost_finished__auditor_id) {
        this.lost_finished__auditor_id = lost_finished__auditor_id;
    }

    @Override
    public String toString() {
        return "LostFinshed{" +
                "lost_finished_internal_id=" + lost_finished_internal_id +
                ", lost_finished_id=" + lost_finished_id +
                ", lost_finished_name='" + lost_finished_name + '\'' +
                ", lost_finished_category=" + lost_finished_category +
                ", lost_finished_desc='" + lost_finished_desc + '\'' +
                ", lost_finished_location='" + lost_finished_location + '\'' +
                ", lost_color=" + lost_color +
                ", lost_finished_img_url='" + lost_finished_img_url + '\'' +
                ", lost_finished_lost_time=" + lost_finished_lost_time +
                ", lost_finished_public_time=" + lost_finished_public_time +
                ", lost_finished_finish_time=" + lost_finished_finish_time +
                '}';
    }
}
;