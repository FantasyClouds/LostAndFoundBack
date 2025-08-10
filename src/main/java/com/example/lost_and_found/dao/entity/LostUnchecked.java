
package com.example.lost_and_found.dao.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.example.lost_and_found.util.ItemType;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDateTime;

/**
 * 寻物启事（待审核）
 */
@TableName("lost_unchecked")
public class LostUnchecked {

    // 内部id，自动生成
    @TableId(type = IdType.AUTO)
    private Long lost_unchecked_internal_id;

    // id，用于查找（非空）
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private Long lost_unchecked_id;

    // 名字（非空）
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String lost_unchecked_name;

    // 种类（非空）
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private ItemType lost_unchecked_category;

    // 描述
    @TableField
    private String lost_unchecked_desc;

    // 丢失地点
    @TableField
    private String lost_unchecked_location;

    // 图片地址
    @TableField
    private String lost_unchecked_img_url;

    // 丢失时间
    @TableField
    private LocalDateTime lost_unchecked_lost_time;

    // 发布时间
    @TableField
    private LocalDateTime lost_unchecked_publish_time;

    // 完成时间
    @TableField
    private LocalDateTime lost_unchecked_finish_time;

    // 评论区
    @TableField(typeHandler = JacksonTypeHandler.class)
    private JsonNode lost_unchecked_comment;

    // 审核员id
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private Long lost_unchecked_author_id;

    public LostUnchecked() {
    }

    public LostUnchecked(Long lost_unchecked_id, String lost_unchecked_name,
                         ItemType lost_unchecked_category, String lost_unchecked_desc, String lost_unchecked_location,
                         String lost_unchecked_img_url, LocalDateTime lost_unchecked_lost_time,
                         LocalDateTime lost_unchecked_publish_time, LocalDateTime lost_unchecked_finish_time,
                         JsonNode lost_unchecked_comment, Long lost_unchecked_author_id) {
        this.lost_unchecked_id = lost_unchecked_id;
        this.lost_unchecked_name = lost_unchecked_name;
        this.lost_unchecked_category = lost_unchecked_category;
        this.lost_unchecked_desc = lost_unchecked_desc;
        this.lost_unchecked_location = lost_unchecked_location;
        this.lost_unchecked_img_url = lost_unchecked_img_url;
        this.lost_unchecked_lost_time = lost_unchecked_lost_time;
        this.lost_unchecked_publish_time = lost_unchecked_publish_time;
        this.lost_unchecked_finish_time = lost_unchecked_finish_time;
        this.lost_unchecked_comment = lost_unchecked_comment;
        this.lost_unchecked_author_id = lost_unchecked_author_id;
    }
    /**
     * 内部id，自动生成
     */
    public Long getLost_unchecked_internal_id() {
        return lost_unchecked_internal_id;
    }
    /**
     * 内部id，自动生成
     */
    public void setLost_unchecked_internal_id(Long lost_unchecked_internal_id) {
        this.lost_unchecked_internal_id = lost_unchecked_internal_id;
    }
    /**
     * id，用于查找（非空）
     */
    public Long getlost_unchecked_id() {
        return lost_unchecked_id;
    }
    /**
     * id，用于查找（非空）
     */
    public void setlost_unchecked_id(Long lost_unchecked_id) {
        this.lost_unchecked_id = lost_unchecked_id;
    }
    /**
     * 名字（非空）
     */
    public String getLost_unchecked_name() {
        return lost_unchecked_name;
    }
    /**
     * 名字（非空）
     */
    public void setLost_unchecked_name(String lost_unchecked_name) {
        this.lost_unchecked_name = lost_unchecked_name;
    }
    /**
     * 种类（非空）
     */
    public ItemType getLost_unchecked_category() {
        return lost_unchecked_category;
    }
    /**
     * 种类（非空）
     */
    public void setLost_unchecked_category(ItemType lost_unchecked_category) {
        this.lost_unchecked_category = lost_unchecked_category;
    }
    /**
     * 描述
     */
    public String getLost_unchecked_desc() {
        return lost_unchecked_desc;
    }
    /**
     * 描述
     */
    public void setLost_unchecked_desc(String lost_unchecked_desc) {
        this.lost_unchecked_desc = lost_unchecked_desc;
    }
    /**
     * 丢失地点
     */
    public String getLost_unchecked_location() {
        return lost_unchecked_location;
    }
    /**
     * 丢失地点
     */
    public void setLost_unchecked_location(String lost_unchecked_location) {
        this.lost_unchecked_location = lost_unchecked_location;
    }
    /**
     * 图片地址
     */
    public String getLost_unchecked_img_url() {
        return lost_unchecked_img_url;
    }
    /**
     * 图片地址
     */
    public void setLost_unchecked_img_url(String lost_unchecked_img_url) {
        this.lost_unchecked_img_url = lost_unchecked_img_url;
    }
    /**
     * 丢失时间
     */
    public LocalDateTime getLost_unchecked_lost_time() {
        return lost_unchecked_lost_time;
    }
    /**
     * 丢失时间
     */
    public void setLost_unchecked_lost_time(LocalDateTime lost_unchecked_lost_time) {
        this.lost_unchecked_lost_time = lost_unchecked_lost_time;
    }
    /**
     * 发布时间
     */
    public LocalDateTime getLost_unchecked_publish_time() {
        return lost_unchecked_publish_time;
    }
    /**
     * 发布时间
     */
    public void setLost_unchecked_publish_time(LocalDateTime lost_unchecked_publish_time) {
        this.lost_unchecked_publish_time = lost_unchecked_publish_time;
    }
    /**
     * 完成时间
     */
    public LocalDateTime getLost_unchecked_finish_time() {
        return lost_unchecked_finish_time;
    }
    /**
     * 完成时间
     */
    public void setLost_unchecked_finish_time(LocalDateTime lost_unchecked_finish_time) {
        this.lost_unchecked_finish_time = lost_unchecked_finish_time;
    }
    /**
     * 评论区
     */
    public JsonNode getLost_unchecked_comment() {
        return lost_unchecked_comment;
    }
    /**
     * 评论区
     */
    public void setLost_unchecked_comment(JsonNode lost_unchecked_comment) {
        this.lost_unchecked_comment = lost_unchecked_comment;
    }
    /**
     * 审核员id（非空，外键）
     */
    public Long getLost_unchecked_author_id() {
        return lost_unchecked_author_id;
    }
    /**
     * 审核员id（非空，外键）
     */
    public void setLost_unchecked_author_id(Long lost_unchecked_author_id) {
        this.lost_unchecked_author_id = lost_unchecked_author_id;
    }

    @Override
    public String toString() {
        return "LostFinshed{" +
                "lost_unchecked_internal_id=" + lost_unchecked_internal_id +
                ", lost_unchecked_id=" + lost_unchecked_id +
                ", lost_unchecked_name='" + lost_unchecked_name + '\'' +
                ", lost_unchecked_category=" + lost_unchecked_category +
                ", lost_unchecked_desc='" + lost_unchecked_desc + '\'' +
                ", lost_unchecked_location='" + lost_unchecked_location + '\'' +
                ", lost_unchecked_img_url='" + lost_unchecked_img_url + '\'' +
                ", lost_unchecked_lost_time=" + lost_unchecked_lost_time +
                ", lost_unchecked_publish_time=" + lost_unchecked_publish_time +
                ", lost_unchecked_finish_time=" + lost_unchecked_finish_time +
                '}';
    }
}
;