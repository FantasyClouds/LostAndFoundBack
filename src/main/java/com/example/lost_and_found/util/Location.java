package com.example.lost_and_found.util;

import com.example.lost_and_found.exception.IllegalLocationNameException;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 位置枚举类
 */
public enum Location {
    XueYou("学友楼"),
    XiaoYou("校友楼"),
    WenZong("文综楼"),
    YiFu("逸夫楼"),
    Road("路边"),
    Dorm("宿舍"),
    Library("图书馆"),
    Canteen("食堂"),
    DaFeng("大丰球场"),
    TianJing("田径场"),
    Lake("湖边"),
    DaHuo("大活"),
    WuPoPark("五坡广场"),
    NorthGate("北门"),
    SouthGate("南门"),
    XueYuan("学院楼"),
    Other("其他"),
    Unknown("未知");

    private final String name;

    Location(String name) {
        this.name = name;
    }

    /**
     * 用于获取枚举的中文名
     * 指定用 name 属性作为序列化值
     */
    //指定用 name 属性作为序列化值
    @JsonValue
    public String getName() {
        return name;
    }

    /**
     * 通过中文名获取枚举
     * 没有枚举值则抛出 IllegalLocationNameException
     */
    public static Location fromChinese(String chinese) {
        for (Location location : values()) {
            if (location.name.equals(chinese)) {
                return location;
            }
        }
        throw new IllegalLocationNameException();
    }
}
