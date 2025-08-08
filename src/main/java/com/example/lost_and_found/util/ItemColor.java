package com.example.lost_and_found.util;

import com.example.lost_and_found.exception.IllegalColorIdException;
import com.example.lost_and_found.exception.IllegalColorNameException;
/**
 * 失物颜色枚举值
 */
public enum ItemColor {
    RED(1, "红色"),
    LIGHT_RED(2, "浅红色"),
    DARK_RED(3,"暗红色"),
    GREEN(4, "绿色"),
    LIGHT_GREEN(5, "浅绿色"),
    DARK_GREEN(6,"暗绿色"),
    BLUE(7, "蓝色"),
    LIGHT_BLUE(8, "浅蓝色"),
    DARK_BLUE(9, "深蓝色"),
    YELLOW(10, "黄色"),
    ORANGE(11, "橙色"),
    PURPLE(12, "紫色"),
    PINK(13, "粉红色"),
    BROWN(14, "棕色"),
    GREY(15, "灰色"),
    BLACK(16, "黑色"),
    WHITE(17,"白色"),
    OTHER(18, "其他");

    private final String name;
    private final int id;

    ItemColor(int id, String name) {
        this.name = name;
        this.id = id;
    }

    /**
     * 用于获取枚举的中文名
     */
    public String getName() {
        return name;
    }
    /**
     * 用于获取枚举的id
     */
    public int getId() {
        return id;
    }

    /**
     * 通过中文名获取枚举
     * 没有枚举值则抛出 IllegalColorNameException
     */
    public static ItemColor fromChinese(String chinese) {
        for (ItemColor color : values()) {
            if (color.name.equals(chinese)) {
                return color;
            }
        }
        throw new IllegalColorNameException();
    }
    /**
     * 通过id获取枚举
     * 没有枚举值则抛出 IllegalColorIdException
     */
    public static ItemColor fromId(int id) {
        for (ItemColor color : values()) {
            if (color.id == id) {
                return color;
                }
            }
        throw new IllegalColorIdException();
    }
}