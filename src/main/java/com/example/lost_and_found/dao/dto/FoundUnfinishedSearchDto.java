package com.example.lost_and_found.dao.dto;

import com.example.lost_and_found.util.ItemColor;
import com.example.lost_and_found.util.ItemType;
import com.example.lost_and_found.util.Location;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用于和前端对接搜索未完成失物的dto
 *
 * 修改说明：
 * 移除了冗余的 getter 和 setter 方法，因为已经使用了@Data注解（lombok 会自动生成）
 * 修复了构造方法中缺少location_detail参数的问题
 * 保持了与前端交互所需的所有搜索参数，包括用于排除已展示项的showed_ids
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
                                    String img_url, LocalDateTime found_time, LocalDateTime publish_time,
                                    List<Long> showed_ids) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.itemType = itemType;
        this.colors = colors;
        this.location = location;
        this.location_detail = location_detail; //增加location_detail参数
        this.img_url = img_url;
        this.found_time = found_time;
        this.publish_time = publish_time;
        this.showed_ids = showed_ids;
    }
}
