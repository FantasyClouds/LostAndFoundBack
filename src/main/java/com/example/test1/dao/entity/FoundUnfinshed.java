
package com.example.test1.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.test1.util.ItemColor;
import com.example.test1.util.ItemType;

import java.time.LocalDateTime;

@TableName("found_unfinshed")
public class FoundUnfinshed {

    @TableId(type = IdType.AUTO)
    private Long found_unfinished_internal_id;

    @TableField
    private Long found_unfinished_id;

    @TableField
    private String found_unfinished_name;

    @TableField
    private ItemType found_unfinished_category;

    @TableField
    private String found_unfinished_desc;

    @TableField
    private String found_unfinished_location;

    @TableField
    private ItemColor found_color;

    @TableField
    private String found_unfinished_img_url;

    @TableField
    private LocalDateTime found_unfinished_found_time;

    @TableField
    private LocalDateTime found_unfinished_public_time;

    public FoundUnfinshed() {
    }

    public FoundUnfinshed(Long found_unfinished_internal_id, String found_unfinished_name, Long found_unfinished_id, ItemType found_unfinished_category, String found_unfinished_desc, String found_unfinished_location, ItemColor found_color, String found_unfinished_img_url, LocalDateTime found_unfinished_found_time, LocalDateTime found_unfinished_public_time) {
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

    public Long getFound_unfinished_internal_id() {
        return found_unfinished_internal_id;
    }

    public void setFound_unfinished_internal_id(Long found_unfinished_internal_id) {
        this.found_unfinished_internal_id = found_unfinished_internal_id;
    }

    public Long getFound_unfinished_id() {
        return found_unfinished_id;
    }

    public void setFound_unfinished_id(Long found_unfinished_id) {
        this.found_unfinished_id = found_unfinished_id;
    }

    public String getFound_unfinished_name() {
        return found_unfinished_name;
    }

    public void setFound_unfinished_name(String found_unfinished_name) {
        this.found_unfinished_name = found_unfinished_name;
    }

    public ItemType getFound_unfinished_category() {
        return found_unfinished_category;
    }

    public void setFound_unfinished_category(ItemType found_unfinished_category) {
        this.found_unfinished_category = found_unfinished_category;
    }

    public String getFound_unfinished_desc() {
        return found_unfinished_desc;
    }

    public void setFound_unfinished_desc(String found_unfinished_desc) {
        this.found_unfinished_desc = found_unfinished_desc;
    }

    public String getFound_unfinished_location() {
        return found_unfinished_location;
    }

    public void setFound_unfinished_location(String found_unfinished_location) {
        this.found_unfinished_location = found_unfinished_location;
    }

    public ItemColor getFound_color() {
        return found_color;
    }

    public void setFound_color(ItemColor found_color) {
        this.found_color = found_color;
    }

    public String getFound_unfinished_img_url() {
        return found_unfinished_img_url;
    }

    public void setFound_unfinished_img_url(String found_unfinished_img_url) {
        this.found_unfinished_img_url = found_unfinished_img_url;
    }

    public LocalDateTime getFound_unfinished_found_time() {
        return found_unfinished_found_time;
    }

    public void setFound_unfinished_found_time(LocalDateTime found_unfinished_found_time) {
        this.found_unfinished_found_time = found_unfinished_found_time;
    }

    public LocalDateTime getFound_unfinished_public_time() {
        return found_unfinished_public_time;
    }

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