
package com.example.lost_and_found.dao.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.example.lost_and_found.util.ItemColor;
import com.example.lost_and_found.util.ItemType;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDateTime;

/**
 * 寻物启事（未完成的）
 */
@TableName("lost_unfinshed")
public class LostUnfinished {

    // 内部id，自动生成
    @TableId(type = IdType.AUTO)
    private Long lost_unfinished_internal_id;

    // id，用于查找，非空
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private Long lost_unfinished_id;

    // 名字，非空
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String lost_unfinished_name;

    // 种类，非空
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private ItemType lost_unfinished_category;

    // 描述
    @TableField
    private String lost_unfinished_desc;

    // 丢失地点
    @TableField
    private String lost_unfinished_location;

    // 颜色，非空
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private ItemColor lost_color;

    // 图片地址
    @TableField
    private String lost_unfinished_img_url;

    // 丢失时间
    @TableField
    private LocalDateTime lost_unfinished_lost_time;

    // 发布时间
    @TableField
    private LocalDateTime lost_unfinished_public_time;

    // 评论区
    @TableField(typeHandler = JacksonTypeHandler.class)
    private JsonNode lost_finished_comment;

    public LostUnfinished() {
    }

    public LostUnfinished(Long lost_unfinished_internal_id, Long lost_unfinished_id, String lost_unfinished_name,
                          ItemType lost_unfinished_category, String lost_unfinished_desc, ItemColor lost_color,
                          String lost_unfinished_location, String lost_unfinished_img_url, LocalDateTime lost_unfinished_lost_time,
                          LocalDateTime lost_unfinished_public_time) {
        this.lost_unfinished_internal_id = lost_unfinished_internal_id;
        this.lost_unfinished_id = lost_unfinished_id;
        this.lost_unfinished_name = lost_unfinished_name;
        this.lost_unfinished_category = lost_unfinished_category;
        this.lost_unfinished_desc = lost_unfinished_desc;
        this.lost_color = lost_color;
        this.lost_unfinished_location = lost_unfinished_location;
        this.lost_unfinished_img_url = lost_unfinished_img_url;
        this.lost_unfinished_lost_time = lost_unfinished_lost_time;
        this.lost_unfinished_public_time = lost_unfinished_public_time;
    }
    /**
     * 内部id，自动生成
     */
    public Long getLost_unfinished_internal_id() {
        return lost_unfinished_internal_id;
    }
    /**
     * 内部id，自动生成
     */
    public void setLost_unfinished_internal_id(Long lost_unfinished_internal_id) {
        this.lost_unfinished_internal_id = lost_unfinished_internal_id;
    }
    /**
     * id，用于查找，非空
     */
    public Long getLost_unfinished_id() {
        return lost_unfinished_id;
    }
    /**
     * id，用于查找，非空
     */
    public void setLost_unfinished_id(Long lost_unfinished_id) {
        this.lost_unfinished_id = lost_unfinished_id;
    }
    /**
     * 名字，非空
     */
    public String getLost_unfinished_name() {
        return lost_unfinished_name;
    }
    /**
     * 名字，非空
     */
    public void setLost_unfinished_name(String lost_unfinished_name) {
        this.lost_unfinished_name = lost_unfinished_name;
    }
    /**
     * 种类，非空
     */
    public ItemType getLost_unfinished_category() {
        return lost_unfinished_category;
    }
    /**
     * 种类，非空
     */
    public void setLost_unfinished_category(ItemType lost_unfinished_category) {
        this.lost_unfinished_category = lost_unfinished_category;
    }
    /**
     * 描述
     */
    public String getLost_unfinished_desc() {
        return lost_unfinished_desc;
    }
    /**
     * 描述
     */
    public void setLost_unfinished_desc(String lost_unfinished_desc) {
        this.lost_unfinished_desc = lost_unfinished_desc;
    }
    /**
     * 丢失地点
     */
    public String getLost_unfinished_location() {
        return lost_unfinished_location;
    }
    /**
     * 丢失地点
     */
    public void setLost_unfinished_location(String lost_unfinished_location) {
        this.lost_unfinished_location = lost_unfinished_location;
    }
    /**
     * 颜色，非空
     */
    public ItemColor getLost_color() {
        return lost_color;
    }
    /**
     * 颜色，非空
     */
    public void setLost_color(ItemColor lost_color) {
        this.lost_color = lost_color;
    }
    /**
     * 图片地址
     */
    public String getLost_unfinished_img_url() {
        return lost_unfinished_img_url;
    }
    /**
     * 图片地址
     */
    public void setLost_unfinished_img_url(String lost_unfinished_img_url) {
        this.lost_unfinished_img_url = lost_unfinished_img_url;
    }
    /**
     * 丢失时间
     */
    public LocalDateTime getLost_unfinished_lost_time() {
        return lost_unfinished_lost_time;
    }
    /**
     * 丢失时间
     */
    public void setLost_unfinished_lost_time(LocalDateTime lost_unfinished_lost_time) {
        this.lost_unfinished_lost_time = lost_unfinished_lost_time;
    }
    /**
     * 发布时间
     */
    public LocalDateTime getLost_unfinished_public_time() {
        return lost_unfinished_public_time;
    }
    /**
     * 发布时间
     */
    public void setLost_unfinished_public_time(LocalDateTime lost_unfinished_public_time) {
        this.lost_unfinished_public_time = lost_unfinished_public_time;
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

    @Override
    public String toString() {
        return "LostUnfinshed{" +
                "lost_unfinished_internal_id=" + lost_unfinished_internal_id +
                ", lost_unfinished_id=" + lost_unfinished_id +
                ", lost_unfinished_name='" + lost_unfinished_name + '\'' +
                ", lost_unfinished_category=" + lost_unfinished_category +
                ", lost_unfinished_desc='" + lost_unfinished_desc + '\'' +
                ", lost_color=" + lost_color +
                ", lost_unfinished_location='" + lost_unfinished_location + '\'' +
                ", lost_unfinished_img_url='" + lost_unfinished_img_url + '\'' +
                ", lost_unfinished_lost_time=" + lost_unfinished_lost_time +
                ", lost_unfinished_public_time=" + lost_unfinished_public_time +
                '}';
    }
}
;