package com.example.lost_and_found.dao.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 颜色实体类
 */
@TableName("color")
public class Color {
    @TableId
    private Integer id;
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String name;

    public Color() {}
    public Color(Integer id, String name) {}

    /**
     * 获取id值
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id值
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取颜色名称
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 设置颜色名称
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
