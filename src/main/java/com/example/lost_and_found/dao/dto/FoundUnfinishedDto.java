package com.example.lost_and_found.dao.dto;

import com.example.lost_and_found.util.ItemColor;
import com.example.lost_and_found.util.ItemType;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用于和前端对接的未完成失物信息
 */
public class FoundUnfinishedDto {
    private Long id;
    private String name;
    private String description;
    private ItemType itemType;
    private List<ItemColor> colors;
    private String location;
    private String img_url;
    private LocalDateTime found_time;
    private LocalDateTime publish_time;

    public FoundUnfinishedDto() {
    }

    public FoundUnfinishedDto(Long id, String name, String description, ItemType itemType,
                              List<ItemColor> colors, String location, String img_url,
                              LocalDateTime found_time, LocalDateTime publish_time) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.itemType = itemType;
        this.colors = colors;
        this.location = location;
        this.img_url = img_url;
        this.found_time = found_time;
        this.publish_time = publish_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public List<ItemColor> getColors() {
        return colors;
    }

    public void setColors(List<ItemColor> colors) {
        this.colors = colors;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public LocalDateTime getFound_time() {
        return found_time;
    }

    public void setFound_time(LocalDateTime found_time) {
        this.found_time = found_time;
    }

    public LocalDateTime getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(LocalDateTime publish_time) {
        this.publish_time = publish_time;
    }
}
