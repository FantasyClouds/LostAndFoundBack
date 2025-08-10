package com.example.lost_and_found.dao.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 颜色物品关联表
 */
@TableName("item_colors")
public class ItemColorConnect {
    @TableId("item_id")
    private Long item_id;
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY, value ="color_id")
    private Integer color_id;

    public ItemColorConnect() {
    }
    public ItemColorConnect(Long item_id, Integer color_id) {
        this.item_id = item_id;
        this.color_id = color_id;
    }

    /**
     * 物品id
     * @return
     */
    public Long getItem_id() {
        return item_id;
    }

    /**
     * 物品id
     * @param item_id
     */
    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    /**
     * 颜色id
     * @return
     */
    public Integer getColor_id() {
        return color_id;
    }

    /**
     * 颜色id
     * @param color_id
     */
    public void setColor_id(Integer color_id) {
        this.color_id = color_id;
    }

}
