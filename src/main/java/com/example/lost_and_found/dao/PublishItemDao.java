package com.example.lost_and_found.dao;


import com.example.lost_and_found.dao.dto.PublishItemDto;
import com.example.lost_and_found.dao.entity.FoundUnfinished;
import com.example.lost_and_found.dao.entity.ItemColorConnect;
import com.example.lost_and_found.dao.mapper.FoundUnfinishedMapper;
import com.example.lost_and_found.dao.mapper.ItemColorMapper;
import com.example.lost_and_found.util.ItemColor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 发布物品数据访问层
 */
@Repository
@Slf4j
public class PublishItemDao {
    private final FoundUnfinishedMapper foundUnfinishedMapper;
    private final ItemColorMapper itemColorMapper;

    @Autowired
    public PublishItemDao(FoundUnfinishedMapper foundUnfinishedMapper, ItemColorMapper itemColorMapper) {
        this.foundUnfinishedMapper = foundUnfinishedMapper;
        this.itemColorMapper = itemColorMapper;
    }
    /**
     * 持久化物品到数据库
     */
    @Transactional
    public void publishItem(PublishItemDto publishItemDto) {
        log.info("publishItem()");
        // 转换主表实体
        FoundUnfinished entity = convertToEntity(publishItemDto);
        // 插入主表记录
        foundUnfinishedMapper.insert(entity);
        // 插入颜色关联
        batchInsertColors(publishItemDto.getId(), publishItemDto.getColors());

    }
    // 转换dto到entity
    private FoundUnfinished convertToEntity(PublishItemDto dto) {
        return new FoundUnfinished(
                dto.getId(),
                dto.getTitle(),
                dto.getCategory(),
                dto.getDescription(),
                dto.getLocation(),
                dto.getImg_url(),
                dto.getPublish_time(),
                dto.getFound_time()
        );
    }
    // 批量插入颜色关联
    private void batchInsertColors(Long itemId, List<ItemColor> colors) {
        // 转换颜色实体流
        List<ItemColorConnect> relations = colors.stream()
                // 过滤无效颜色（根据业务需求）
                .filter(color -> color.getId() > 0)
                // 构建关联关系
                .map(color -> new ItemColorConnect(itemId, color.getId()))
                .collect(Collectors.toList());

        // 批量插入（使用MyBatis-Plus的扩展方法）
        if (!relations.isEmpty()) {
            itemColorMapper.batchInsert(relations);
        }
    }
}
