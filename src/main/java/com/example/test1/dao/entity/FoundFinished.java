
package com.example.test1.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.example.test1.util.ItemColor;
import com.example.test1.util.ItemType;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDateTime;

@TableName("found_finished")
public class FoundFinished {

    @TableId(type = IdType.AUTO)
    private Long found_finished_internal_id;

    @TableField
    private Long found_finished_id;

    @TableField
    private String found_finished_name;

    @TableField
    private ItemType found_finished_category;

    @TableField
    private String found_finished_desc;

    @TableField
    private String found_finished_location;

    @TableField
    private ItemColor found_color;

    @TableField
    private String found_finished_img_url;

    @TableField
    private LocalDateTime found_finished_found_time;

    @TableField
    private LocalDateTime found_finished_public_time;

    @TableField
    private LocalDateTime found_finished_finish_time;

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

    public Long getFound_finished_internal_id() {
        return found_finished_internal_id;
    }

    public void setFound_finished_internal_id(Long found_finished_internal_id) {
        this.found_finished_internal_id = found_finished_internal_id;
    }

    public Long getFound_finished_id() {
        return found_finished_id;
    }

    public void setFound_finished_id(Long found_finished_id) {
        this.found_finished_id = found_finished_id;
    }

    public String getFound_finished_name() {
        return found_finished_name;
    }

    public void setFound_finished_name(String found_finished_name) {
        this.found_finished_name = found_finished_name;
    }

    public ItemType getFound_finished_category() {
        return found_finished_category;
    }

    public void setFound_finished_category(ItemType found_finished_category) {
        this.found_finished_category = found_finished_category;
    }

    public String getFound_finished_desc() {
        return found_finished_desc;
    }

    public void setFound_finished_desc(String found_finished_desc) {
        this.found_finished_desc = found_finished_desc;
    }

    public String getFound_finished_location() {
        return found_finished_location;
    }

    public void setFound_finished_location(String found_finished_location) {
        this.found_finished_location = found_finished_location;
    }

    public ItemColor getFound_color() {
        return found_color;
    }

    public void setFound_color(ItemColor found_color) {
        this.found_color = found_color;
    }

    public String getFound_finished_img_url() {
        return found_finished_img_url;
    }

    public void setFound_finished_img_url(String found_finished_img_url) {
        this.found_finished_img_url = found_finished_img_url;
    }

    public LocalDateTime getFound_finished_found_time() {
        return found_finished_found_time;
    }

    public void setFound_finished_found_time(LocalDateTime found_finished_found_time) {
        this.found_finished_found_time = found_finished_found_time;
    }

    public LocalDateTime getFound_finished_public_time() {
        return found_finished_public_time;
    }

    public void setFound_finished_public_time(LocalDateTime found_finished_public_time) {
        this.found_finished_public_time = found_finished_public_time;
    }

    public LocalDateTime getFound_finished_finish_time() {
        return found_finished_finish_time;
    }

    public void setFound_finished_finish_time(LocalDateTime found_finished_finish_time) {
        this.found_finished_finish_time = found_finished_finish_time;
    }

    public JsonNode getLost_unfinished_comment() {
        return lost_unfinished_comment;
    }

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