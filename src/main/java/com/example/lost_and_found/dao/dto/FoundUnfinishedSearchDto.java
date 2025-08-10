package com.example.lost_and_found.dao.dto;

import com.example.lost_and_found.util.ItemColor;
import com.example.lost_and_found.util.ItemType;
import com.example.lost_and_found.util.Location;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用于和前端对接搜索未完成失物的dto
 */
@Data
public class FoundUnfinishedSearchDto {
    private Long id;
    private String name;
    private String description;
    private ItemType itemType;
    private List<ItemColor> colors;
    private Location location;
    private String location_detail;
    private String img_url;
    private LocalDateTime found_time;
    private LocalDateTime publish_time;
    private List<Long> showed_ids;

    public FoundUnfinishedSearchDto() {
    }

    public FoundUnfinishedSearchDto(Long id, String name, String description, ItemType itemType,
                                    List<ItemColor> colors, Location location, String location_detail,
                                    String img_url, LocalDateTime found_time, LocalDateTime publish_time, List<Long> showed_ids) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.itemType = itemType;
        this.colors = colors;
        this.location = location;
        this.img_url = img_url;
        this.found_time = found_time;
        this.publish_time = publish_time;
        this.showed_ids = showed_ids;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getLocation_detail() {
        return location_detail;
    }

    public void setLocation_detail(String location_detail) {
        this.location_detail = location_detail;
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

    public List<Long> getShowed_ids() {
        return showed_ids;
    }

    public void setShowed_ids(List<Long> showed_ids) {
        this.showed_ids = showed_ids;
    }
}
