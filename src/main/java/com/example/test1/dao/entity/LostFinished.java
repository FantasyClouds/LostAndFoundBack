
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

@TableName("lost_finished")
public class LostFinished {

    @TableId(type = IdType.AUTO)
    private Long lost_finished_internal_id;

    @TableField
    private Long lost_finished_id;

    @TableField
    private String lost_finished_name;

    @TableField
    private ItemType lost_finished_category;

    @TableField
    private String lost_finished_desc;

    @TableField
    private String lost_finished_location;

    @TableField
    private ItemColor lost_color;

    @TableField
    private String lost_finished_img_url;

    @TableField
    private LocalDateTime lost_finished_found_time;

    @TableField
    private LocalDateTime lost_finished_public_time;

    @TableField
    private LocalDateTime lost_finished_finish_time;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private JsonNode lost_finished_comment;

    public LostFinished() {
    }

    public LostFinished(Long lost_finished_internal_id, Long lost_finished_id, String lost_finished_name, ItemType lost_finished_category, String lost_finished_desc, String lost_finished_location, ItemColor lost_color, String lost_finished_img_url, LocalDateTime lost_finished_found_time, LocalDateTime lost_finished_public_time, LocalDateTime lost_finished_finish_time, JsonNode lost_finished_comment) {
        this.lost_finished_internal_id = lost_finished_internal_id;
        this.lost_finished_id = lost_finished_id;
        this.lost_finished_name = lost_finished_name;
        this.lost_finished_category = lost_finished_category;
        this.lost_finished_desc = lost_finished_desc;
        this.lost_finished_location = lost_finished_location;
        this.lost_color = lost_color;
        this.lost_finished_img_url = lost_finished_img_url;
        this.lost_finished_found_time = lost_finished_found_time;
        this.lost_finished_public_time = lost_finished_public_time;
        this.lost_finished_finish_time = lost_finished_finish_time;
        this.lost_finished_comment = lost_finished_comment;
    }

    public Long getLost_finished_internal_id() {
        return lost_finished_internal_id;
    }

    public void setLost_finished_internal_id(Long lost_finished_internal_id) {
        this.lost_finished_internal_id = lost_finished_internal_id;
    }

    public Long getLost_finished_id() {
        return lost_finished_id;
    }

    public void setLost_finished_id(Long lost_finished_id) {
        this.lost_finished_id = lost_finished_id;
    }

    public String getLost_finished_name() {
        return lost_finished_name;
    }

    public void setLost_finished_name(String lost_finished_name) {
        this.lost_finished_name = lost_finished_name;
    }

    public ItemType getLost_finished_category() {
        return lost_finished_category;
    }

    public void setLost_finished_category(ItemType lost_finished_category) {
        this.lost_finished_category = lost_finished_category;
    }

    public String getLost_finished_desc() {
        return lost_finished_desc;
    }

    public void setLost_finished_desc(String lost_finished_desc) {
        this.lost_finished_desc = lost_finished_desc;
    }

    public String getLost_finished_location() {
        return lost_finished_location;
    }

    public void setLost_finished_location(String lost_finished_location) {
        this.lost_finished_location = lost_finished_location;
    }

    public ItemColor getLost_color() {
        return lost_color;
    }

    public void setLost_color(ItemColor lost_color) {
        this.lost_color = lost_color;
    }

    public String getLost_finished_img_url() {
        return lost_finished_img_url;
    }

    public void setLost_finished_img_url(String lost_finished_img_url) {
        this.lost_finished_img_url = lost_finished_img_url;
    }

    public LocalDateTime getLost_finished_found_time() {
        return lost_finished_found_time;
    }

    public void setLost_finished_found_time(LocalDateTime lost_finished_found_time) {
        this.lost_finished_found_time = lost_finished_found_time;
    }

    public LocalDateTime getLost_finished_public_time() {
        return lost_finished_public_time;
    }

    public void setLost_finished_public_time(LocalDateTime lost_finished_public_time) {
        this.lost_finished_public_time = lost_finished_public_time;
    }

    public LocalDateTime getLost_finished_finish_time() {
        return lost_finished_finish_time;
    }

    public void setLost_finished_finish_time(LocalDateTime lost_finished_finish_time) {
        this.lost_finished_finish_time = lost_finished_finish_time;
    }

    public JsonNode getLost_finished_comment() {
        return lost_finished_comment;
    }

    public void setLost_finished_comment(JsonNode lost_finished_comment) {
        this.lost_finished_comment = lost_finished_comment;
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
                ", lost_finished_found_time=" + lost_finished_found_time +
                ", lost_finished_public_time=" + lost_finished_public_time +
                ", lost_finished_finish_time=" + lost_finished_finish_time +
                '}';
    }
}
;