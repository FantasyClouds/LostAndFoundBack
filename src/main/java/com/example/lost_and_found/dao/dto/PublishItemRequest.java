package com.example.lost_and_found.dao.dto;


import com.example.lost_and_found.util.ItemColor;
import com.example.lost_and_found.util.ItemType;
import com.example.lost_and_found.util.Location;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用于管理员发布物品的请求dto对象
 * 起到安全防护作用和数据统一作用
 */
@Data
public class PublishItemRequest {
    private String name;
    private ItemType type;
    private List<ItemColor> color;
    private String description;
    private Location found_location;
    private String found_location_detail;
    private String imgUrl;
    private LocalDateTime found_time;
    private Long publish_user_id;
    private LocalDateTime publish_time;

    public PublishItemRequest() {
    }

    public PublishItemRequest(String name, ItemType type, List<ItemColor> color,
                              String description, Location found_location, String found_location_detail,
                              String imgUrl, LocalDateTime found_time, Long publish_user_id, LocalDateTime publish_time) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.description = description;
        this.found_location = found_location;
        this.found_location_detail = found_location_detail;
        this.imgUrl = imgUrl;
        this.found_time = found_time;
        this.publish_user_id = publish_user_id;
        this.publish_time = publish_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public List<ItemColor> getColor() {
        return color;
    }

    public void setColor(List<ItemColor> color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getFound_location() {
        return found_location;
    }

    public void setFound_location(Location found_location) {
        this.found_location = found_location;
    }

    public String getFound_location_detail() {
        return found_location_detail;
    }

    public void setFound_location_detail(String found_location_detail) {
        this.found_location_detail = found_location_detail;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public LocalDateTime getFound_time() {
        return found_time;
    }

    public void setFound_time(LocalDateTime found_time) {
        this.found_time = found_time;
    }

    public Long getPublish_user_id() {
        return publish_user_id;
    }

    public void setPublish_user_id(Long publish_user_id) {
        this.publish_user_id = publish_user_id;
    }

    public LocalDateTime getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(LocalDateTime publish_time) {
        this.publish_time = publish_time;
    }
}