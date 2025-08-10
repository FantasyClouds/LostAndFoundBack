package com.example.lost_and_found.service;

import com.example.lost_and_found.dao.ItemColorDao;
import com.example.lost_and_found.dao.dto.ItemDto;
import com.example.lost_and_found.dao.entity.FoundUnfinished;
import com.example.lost_and_found.dao.mapper.FoundUnfinishedMapper;
import com.example.lost_and_found.util.ItemColor;
import com.example.lost_and_found.util.LocationString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  用于返回失物详情的业务类
 */
@Service
@Slf4j
public class ItemDetailService {
    private final FoundUnfinishedMapper FoundUnfinishedMapper;
    private final ItemColorDao itemColorDao;

    @Autowired
    public ItemDetailService(FoundUnfinishedMapper id, ItemColorDao itemColorDao){
        FoundUnfinishedMapper = id;
        this.itemColorDao = itemColorDao;
    }
    /**
     * 用于返回未完成的失物招领
     */
    public ItemDto foundUnfinishedDetail(Long id) {
        log.info("foundUnfinishedDetail()");
        List<ItemColor> colors = itemColorDao.getItemColorsById(id);
        FoundUnfinished foundUnfinished = FoundUnfinishedMapper.selectById(id);
        ItemDto itemDto;
        LocationString locationString = new LocationString(foundUnfinished.getFound_unfinished_location());
        itemDto = new ItemDto(
                foundUnfinished.getFound_unfinished_id(),
                foundUnfinished.getFound_unfinished_name(),
                foundUnfinished.getFound_unfinished_desc(),
                foundUnfinished.getFound_unfinished_category(),
                colors,
                locationString,
                foundUnfinished.getFound_unfinished_img_url(),
                foundUnfinished.getFound_unfinished_found_time(),
                foundUnfinished.getFound_unfinished_publish_time()
        );
        return itemDto;
    }
}