
package com.example.test1.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.test1.util.ItemColor;
import com.example.test1.util.ItemType;

import java.time.LocalDateTime;

@TableName("lost_unfinshed")
public class LostUnfinished {

    @TableId(type = IdType.AUTO)
    private Long lost_unfinished_internal_id;

    @TableField
    private Long lost_unfinished_id;

    @TableField
    private String lost_unfinished_name;

    @TableField
    private ItemType lost_unfinished_category;

    @TableField
    private String lost_unfinished_desc;

    @TableField
    private String lost_unfinished_location;

    @TableField
    private ItemColor lost_color;

    @TableField
    private String lost_unfinished_img_url;

    @TableField
    private LocalDateTime lost_unfinished_found_time;

    @TableField
    private LocalDateTime lost_unfinished_public_time;

    public LostUnfinished() {
    }

    public LostUnfinished(Long lost_unfinished_internal_id, Long lost_unfinished_id, String lost_unfinished_name, ItemType lost_unfinished_category, String lost_unfinished_desc, ItemColor lost_color, String lost_unfinished_location, String lost_unfinished_img_url, LocalDateTime lost_unfinished_found_time, LocalDateTime lost_unfinished_public_time) {
        this.lost_unfinished_internal_id = lost_unfinished_internal_id;
        this.lost_unfinished_id = lost_unfinished_id;
        this.lost_unfinished_name = lost_unfinished_name;
        this.lost_unfinished_category = lost_unfinished_category;
        this.lost_unfinished_desc = lost_unfinished_desc;
        this.lost_color = lost_color;
        this.lost_unfinished_location = lost_unfinished_location;
        this.lost_unfinished_img_url = lost_unfinished_img_url;
        this.lost_unfinished_found_time = lost_unfinished_found_time;
        this.lost_unfinished_public_time = lost_unfinished_public_time;
    }

    public Long getLost_unfinished_internal_id() {
        return lost_unfinished_internal_id;
    }

    public void setLost_unfinished_internal_id(Long lost_unfinished_internal_id) {
        this.lost_unfinished_internal_id = lost_unfinished_internal_id;
    }

    public Long getLost_unfinished_id() {
        return lost_unfinished_id;
    }

    public void setLost_unfinished_id(Long lost_unfinished_id) {
        this.lost_unfinished_id = lost_unfinished_id;
    }

    public String getLost_unfinished_name() {
        return lost_unfinished_name;
    }

    public void setLost_unfinished_name(String lost_unfinished_name) {
        this.lost_unfinished_name = lost_unfinished_name;
    }

    public ItemType getLost_unfinished_category() {
        return lost_unfinished_category;
    }

    public void setLost_unfinished_category(ItemType lost_unfinished_category) {
        this.lost_unfinished_category = lost_unfinished_category;
    }

    public String getLost_unfinished_desc() {
        return lost_unfinished_desc;
    }

    public void setLost_unfinished_desc(String lost_unfinished_desc) {
        this.lost_unfinished_desc = lost_unfinished_desc;
    }

    public String getLost_unfinished_location() {
        return lost_unfinished_location;
    }

    public void setLost_unfinished_location(String lost_unfinished_location) {
        this.lost_unfinished_location = lost_unfinished_location;
    }

    public ItemColor getLost_color() {
        return lost_color;
    }

    public void setLost_color(ItemColor lost_color) {
        this.lost_color = lost_color;
    }

    public String getLost_unfinished_img_url() {
        return lost_unfinished_img_url;
    }

    public void setLost_unfinished_img_url(String lost_unfinished_img_url) {
        this.lost_unfinished_img_url = lost_unfinished_img_url;
    }

    public LocalDateTime getLost_unfinished_found_time() {
        return lost_unfinished_found_time;
    }

    public void setLost_unfinished_found_time(LocalDateTime lost_unfinished_found_time) {
        this.lost_unfinished_found_time = lost_unfinished_found_time;
    }

    public LocalDateTime getLost_unfinished_public_time() {
        return lost_unfinished_public_time;
    }

    public void setLost_unfinished_public_time(LocalDateTime lost_unfinished_public_time) {
        this.lost_unfinished_public_time = lost_unfinished_public_time;
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
                ", lost_unfinished_found_time=" + lost_unfinished_found_time +
                ", lost_unfinished_public_time=" + lost_unfinished_public_time +
                '}';
    }
}
;