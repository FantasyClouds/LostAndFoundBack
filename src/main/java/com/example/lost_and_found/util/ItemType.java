package com.example.lost_and_found.util;

import com.example.lost_and_found.exception.IllegalItemTypeCodeException;
import com.example.lost_and_found.exception.IllegalItemTypeNameException;

/**
 * 失物类型枚举值
 */
public enum ItemType {
    BOOK(1,"书"),
    BAG(2,"包"),
    CARD(3,"卡"),
    KEY(4,"钥匙"),
    PHONE(5,"手机"),
    WATCH(6,"手表"),
    PEN(7,"笔"),
    UMBRELLA(8,"伞"),
    EARPHONE(9,"耳机"),
    OTHER(10,"其他");

    private final String name;
    private final int code;

    ItemType(int code, String name) {
        this.name = name;
        this.code = code;
    }

    /**
     * 用于获取枚举的中文名
     */
    public String getName() {
        return name;
    }
    /**
     * 用于获取枚举的中文名
     */
    public int getCode() {
        return code;
    }

    /**
     * 通过中文名获取枚举
     * 没有枚举值则抛出 IllegalItemTypeNameException
     */
    public static ItemType fromChinese(String chinese) {
        for (ItemType type : values()) {
            if (type.name.equals(chinese)) {
                return type;
            }
        }
        throw new IllegalItemTypeNameException();
    }
    /**
     * 通过数字id获取枚举
     * 没有枚举值则抛出 IllegalItemTypeCodeException
     */
    public static ItemType fromCode(int code) {
        for (ItemType type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw new IllegalItemTypeCodeException();
    }
}
