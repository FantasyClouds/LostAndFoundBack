
package com.example.lost_and_found.dao.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.example.lost_and_found.util.ItemColor;
import com.example.lost_and_found.util.ItemType;

import java.time.LocalDateTime;

/**
 * 未完成的失物招领
 */
@TableName("found_unfinshed")
public class FoundUnfinished {

    @TableId(type = IdType.AUTO)
    private Long found_unfinished_internal_id;

    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private Long found_unfinished_id;

    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String found_unfinished_name;

    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private ItemType found_unfinished_category;

    @TableField
    private String found_unfinished_desc;

    @TableField
    private String found_unfinished_location;

    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private ItemColor found_color;

    @TableField
    private String found_unfinished_img_url;

    @TableField
    private LocalDateTime found_unfinished_found_time;

    @TableField
    private LocalDateTime found_unfinished_public_time;

    public FoundUnfinished() {
    }

    public FoundUnfinished(Long found_unfinished_internal_id, String found_unfinished_name, Long found_unfinished_id,
                           ItemType found_unfinished_category, String found_unfinished_desc, String found_unfinished_location,
                           ItemColor found_color, String found_unfinished_img_url, LocalDateTime found_unfinished_found_time,
                           LocalDateTime found_unfinished_public_time) {
        this.found_unfinished_internal_id = found_unfinished_internal_id;
        this.found_unfinished_name = found_unfinished_name;
        this.found_unfinished_id = found_unfinished_id;
        this.found_unfinished_category = found_unfinished_category;
        this.found_unfinished_desc = found_unfinished_desc;
        this.found_unfinished_location = found_unfinished_location;
        this.found_color = found_color;
        this.found_unfinished_img_url = found_unfinished_img_url;
        this.found_unfinished_found_time = found_unfinished_found_time;
        this.found_unfinished_public_time = found_unfinished_public_time;
    }
    /**
     * 内部id，自动生成
     */
    public Long getFound_unfinished_internal_id() {
        return found_unfinished_internal_id;
    }
    /**
     * 内部id，自动生成
     */
    public void setFound_unfinished_internal_id(Long found_unfinished_internal_id) {
        this.found_unfinished_internal_id = found_unfinished_internal_id;
    }
    /**
     * id，用于查找，非空
     */
    public Long getFound_unfinished_id() {
        return found_unfinished_id;
    }
    /**
     * id，用于查找，非空
     */
    public void setFound_unfinished_id(Long found_unfinished_id) {
        this.found_unfinished_id = found_unfinished_id;
    }
    /**
     * 名字，非空
     */
    public String getFound_unfinished_name() {
        return found_unfinished_name;
    }
    /**
     * 名字，非空
     */
    public void setFound_unfinished_name(String found_unfinished_name) {
        this.found_unfinished_name = found_unfinished_name;
    }
    /**
     * 种类，非空
     */
    public ItemType getFound_unfinished_category() {
        return found_unfinished_category;
    }
    /**
     * 种类，非空
     */
    public void setFound_unfinished_category(ItemType found_unfinished_category) {
        this.found_unfinished_category = found_unfinished_category;
    }
    /**
     * 描述
     */
    public String getFound_unfinished_desc() {
        return found_unfinished_desc;
    }
    /**
     * 描述
     */
    public void setFound_unfinished_desc(String found_unfinished_desc) {
        this.found_unfinished_desc = found_unfinished_desc;
    }
    /**
     * 捡到地点
     */
    public String getFound_unfinished_location() {
        return found_unfinished_location;
    }
    /**
     * 捡到地点
     */
    public void setFound_unfinished_location(String found_unfinished_location) {
        this.found_unfinished_location = found_unfinished_location;
    }
    /**
     * 颜色，非空
     */
    public ItemColor getFound_color() {
        return found_color;
    }
    /**
     * 颜色，非空
     */
    public void setFound_color(ItemColor found_color) {
        this.found_color = found_color;
    }
    /**
     * 图片url
     */
    public String getFound_unfinished_img_url() {
        return found_unfinished_img_url;
    }
    /**
     * 图片url
     */
    public void setFound_unfinished_img_url(String found_unfinished_img_url) {
        this.found_unfinished_img_url = found_unfinished_img_url;
    }
    /**
     * 捡到时间
     */
    public LocalDateTime getFound_unfinished_found_time() {
        return found_unfinished_found_time;
    }
    /**
     * 捡到时间
     */
    public void setFound_unfinished_found_time(LocalDateTime found_unfinished_found_time) {
        this.found_unfinished_found_time = found_unfinished_found_time;
    }
    /**
     * 发布时间
     */
    public LocalDateTime getFound_unfinished_public_time() {
        return found_unfinished_public_time;
    }
    /**
     * 发布时间
     */
    public void setFound_unfinished_public_time(LocalDateTime found_unfinished_public_time) {
        this.found_unfinished_public_time = found_unfinished_public_time;
    }

    @Override
    public String toString() {
        return "FoundUnfinshed{" +
                "found_unfinished_internal_id=" + found_unfinished_internal_id +
                ", found_unfinished_id=" + found_unfinished_id +
                ", found_unfinished_name='" + found_unfinished_name + '\'' +
                ", found_unfinished_category=" + found_unfinished_category +
                ", found_unfinished_desc='" + found_unfinished_desc + '\'' +
                ", found_unfinished_location='" + found_unfinished_location + '\'' +
                ", found_color=" + found_color +
                ", found_unfinished_img_url='" + found_unfinished_img_url + '\'' +
                ", found_unfinished_found_time=" + found_unfinished_found_time +
                ", found_unfinished_public_time=" + found_unfinished_public_time +
                '}';
    }
}
;