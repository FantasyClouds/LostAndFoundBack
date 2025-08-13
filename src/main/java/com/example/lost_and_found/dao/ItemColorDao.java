package com.example.lost_and_found.dao;

import com.example.lost_and_found.dao.entity.Color;
import com.example.lost_and_found.dao.mapper.ItemColorMapper;
import com.example.lost_and_found.util.ItemColor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于失物颜色相关的数据库操作
 */
@Repository
@Slf4j
public class ItemColorDao {
    private final ItemColorMapper itemColorMapper;

    @Autowired
    public ItemColorDao(ItemColorMapper itemColorMapper) {
        this.itemColorMapper = itemColorMapper;
    }

    /**
     * 根据id获取失物颜色列表
     * @param id
     * @return
     */
    public List<ItemColor> getItemColorsById(Long id) {
        log.info("getItemColorsById()");
        List<ItemColor> result = new ArrayList<>();
        List<Color> itemColors = itemColorMapper.findColorsByItemId(id);
        for (Color itemColor : itemColors) {
            result.add(ItemColor.fromId(itemColor.getId()));
        }
        return result;
    }


}
