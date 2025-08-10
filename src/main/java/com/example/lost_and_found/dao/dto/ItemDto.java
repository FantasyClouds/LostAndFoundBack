package com.example.lost_and_found.dao.dto;

import com.example.lost_and_found.util.ItemColor;
import com.example.lost_and_found.util.ItemType;
import com.example.lost_and_found.util.LocationString;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 失物信息的dto类，用于各层之间传输失物信息
 * 不管你是失物招领还是寻物启事，都可以用此类的统一格式传输信息
 * 该类可用作Dao层和Entity类连接。
 */
@Data
public class ItemDto {
    private Long id;
    private String name;
    private String description;
    private ItemType itemType;
    private List<ItemColor> colors;
    private LocationString location;
    private String img_url;
    private LocalDateTime found_or_lost_time;
    private LocalDateTime publish_time;

    public ItemDto() {
    }

    public ItemDto(Long id, String name, String description, ItemType itemType,
                   List<ItemColor> colors, LocationString location, String img_url,
                   LocalDateTime found_or_lost_time, LocalDateTime publish_time) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.itemType = itemType;
        this.colors = colors;
        this.location = location;
        this.img_url = img_url;
        this.found_or_lost_time = found_or_lost_time;
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

    public LocationString getLocation() {
        return location;
    }

    public void setLocation(LocationString location) {
        this.location = location;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public LocalDateTime getFound_or_lost_time() {
        return found_or_lost_time;
    }

    public void setFound_or_lost_time(LocalDateTime found_or_lost_time) {
        this.found_or_lost_time = found_or_lost_time;
    }

    public LocalDateTime getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(LocalDateTime publish_time) {
        this.publish_time = publish_time;
    }
}
