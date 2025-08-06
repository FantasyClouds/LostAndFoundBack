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
    private String imgUrl;
    private LocalDateTime found_time;
    private Long publish_user_id;
    private LocalDateTime publish_time;
}