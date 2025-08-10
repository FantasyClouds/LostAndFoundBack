package com.example.lost_and_found.dao.dto;

import com.example.lost_and_found.util.ItemColor;
import com.example.lost_and_found.util.ItemType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用于发布物品和数据库对接的DTO
 */
@Data
public class PublishItemDto {
    private Long id;
    private String title;
    private String description;
    private ItemType category;
    private String location;
    private List<ItemColor> colors;
    private String img_url;
    private LocalDateTime publish_time;
    private LocalDateTime found_time;

    public PublishItemDto(Long id, String title, String description,
                          ItemType category, String location, List<ItemColor> colors,
                          String img_url, LocalDateTime publish_time, LocalDateTime found_time) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.location = location;
        this.colors = colors;
        this.img_url = img_url;
        this.publish_time = publish_time;
        this.found_time = found_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemType getCategory() {
        return category;
    }

    public void setCategory(ItemType category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(LocalDateTime publish_time) {
        this.publish_time = publish_time;
    }

    public List<ItemColor> getColors() {
        return colors;
    }

    public void setColors(List<ItemColor> colors) {
        this.colors = colors;
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
}
