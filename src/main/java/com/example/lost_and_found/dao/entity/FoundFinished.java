
package com.example.lost_and_found.dao.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.example.lost_and_found.util.ItemColor;
import com.example.lost_and_found.util.ItemType;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDateTime;

/**
 * 已完成的失物招领实体
 */
@TableName("found_finished")
public class FoundFinished {

    // 内部id，自动生成
    @TableId(type = IdType.AUTO)
    private Long found_finished_internal_id;

    // id，唯一标识，由用户生成，供查询（非空）
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private Long found_finished_id;

    // 名字（非空）
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String found_finished_name;

    // 类型（非空）
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private ItemType found_finished_category;

    // 描述
    @TableField
    private String found_finished_desc;

    // 捡到地点
    @TableField
    private String found_finished_location;

    // 颜色（非空）
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private ItemColor found_color;

    // 图片url
    @TableField
    private String found_finished_img_url;

    // 捡到时间
    @TableField
    private LocalDateTime found_finished_found_time;

    // 发布时间
    @TableField
    private LocalDateTime found_finished_public_time;

    // 完成时间
    @TableField
    private LocalDateTime found_finished_finish_time;

    // 评论区
    @TableField(typeHandler = JacksonTypeHandler.class)
    private JsonNode lost_unfinished_comment;

    public FoundFinished() {
    }

    public FoundFinished(Long found_finished_internal_id, Long found_finished_id, String found_finished_name,
                         ItemType found_finished_category, String found_finished_desc, String found_finished_location,
                         ItemColor found_color, String found_finished_img_url, LocalDateTime found_finished_found_time,
                         LocalDateTime found_finished_public_time, LocalDateTime found_finished_finish_time,
                         JsonNode lost_unfinished_comment) {
        this.found_finished_internal_id = found_finished_internal_id;
        this.found_finished_id = found_finished_id;
        this.found_finished_name = found_finished_name;
        this.found_finished_category = found_finished_category;
        this.found_finished_desc = found_finished_desc;
        this.found_finished_location = found_finished_location;
        this.found_color = found_color;
        this.found_finished_img_url = found_finished_img_url;
        this.found_finished_found_time = found_finished_found_time;
        this.found_finished_public_time = found_finished_public_time;
        this.found_finished_finish_time = found_finished_finish_time;
        this.lost_unfinished_comment = lost_unfinished_comment;
    }
    /**
     * 内部id，自动生成
     */
    public Long getFound_finished_internal_id() {
        return found_finished_internal_id;
    }
    /**
     * 内部id，自动生成
     */
    public void setFound_finished_internal_id(Long found_finished_internal_id) {
        this.found_finished_internal_id = found_finished_internal_id;
    }
    /**
     * id，唯一标识，由用户生成，供查询（非空）
     */
    public Long getFound_finished_id() {
        return found_finished_id;
    }
    /**
     * id，唯一标识，由用户生成，供查询（非空）
     */
    public void setFound_finished_id(Long found_finished_id) {
        this.found_finished_id = found_finished_id;
    }

    /**
     * 名字（非空）
     */
    public String getFound_finished_name() {
        return found_finished_name;
    }

    /**
     * 名字（非空）
     */
    public void setFound_finished_name(String found_finished_name) {
        this.found_finished_name = found_finished_name;
    }

    /**
     * 类型（非空）
     */
    public ItemType getFound_finished_category() {
        return found_finished_category;
    }

    /**
     * 类型（非空）
     */
    public void setFound_finished_category(ItemType found_finished_category) {
        this.found_finished_category = found_finished_category;
    }

    /**
     * 描述
     */
    public String getFound_finished_desc() {
        return found_finished_desc;
    }

    /**
     * 描述
     */
    public void setFound_finished_desc(String found_finished_desc) {
        this.found_finished_desc = found_finished_desc;
    }

    /**
     * 捡到地点
     */
    public String getFound_finished_location() {
        return found_finished_location;
    }

    /**
     * 捡到地点
     */
    public void setFound_finished_location(String found_finished_location) {
        this.found_finished_location = found_finished_location;
    }

    /**
     * 颜色（非空）
     */
    public ItemColor getFound_color() {
        return found_color;
    }

    /**
     * 颜色（非空）
     */
    public void setFound_color(ItemColor found_color) {
        this.found_color = found_color;
    }

    /**
     * 图片url
     */
    public String getFound_finished_img_url() {
        return found_finished_img_url;
    }

    /**
     * 图片url
     */
    public void setFound_finished_img_url(String found_finished_img_url) {
        this.found_finished_img_url = found_finished_img_url;
    }

    /**
     * 捡到时间
     */
    public LocalDateTime getFound_finished_found_time() {
        return found_finished_found_time;
    }

    /**
     * 捡到时间
     */
    public void setFound_finished_found_time(LocalDateTime found_finished_found_time) {
        this.found_finished_found_time = found_finished_found_time;
    }

    /**
     * 发布时间
     */
    public LocalDateTime getFound_finished_public_time() {
        return found_finished_public_time;
    }

    /**
     * 发布时间
     */
    public void setFound_finished_public_time(LocalDateTime found_finished_public_time) {
        this.found_finished_public_time = found_finished_public_time;
    }

    /**
     * 完成时间
     */
    public LocalDateTime getFound_finished_finish_time() {
        return found_finished_finish_time;
    }

    /**
     * 完成时间
     */
    public void setFound_finished_finish_time(LocalDateTime found_finished_finish_time) {
        this.found_finished_finish_time = found_finished_finish_time;
    }

    /**
     * 评论区
     */
    public JsonNode getLost_unfinished_comment() {
        return lost_unfinished_comment;
    }

    /**
     * 评论区
     */
    public void setLost_unfinished_comment(JsonNode lost_unfinished_comment) {
        this.lost_unfinished_comment = lost_unfinished_comment;
    }

    @Override
    public String toString() {
        return "FoundFinshed{" +
                "found_finished_internal_id=" + found_finished_internal_id +
                ", found_finished_id=" + found_finished_id +
                ", found_finished_name='" + found_finished_name + '\'' +
                ", found_finished_category=" + found_finished_category +
                ", found_finished_desc='" + found_finished_desc + '\'' +
                ", found_finished_location='" + found_finished_location + '\'' +
                ", found_color=" + found_color +
                ", found_finished_img_url='" + found_finished_img_url + '\'' +
                ", found_finished_found_time=" + found_finished_found_time +
                ", found_finished_public_time=" + found_finished_public_time +
                ", found_finished_finish_time=" + found_finished_finish_time +
                '}';
    }
}
;