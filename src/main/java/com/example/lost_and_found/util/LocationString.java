package com.example.lost_and_found.util;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 标准地点字符串工具类。
 *
 * 修改说明：
 * 修复了解析地点字符串时的正则处理，正确去除中括号
 * 完善了calculateLocationString方法的空值处理
 * 优化了构造函数的逻辑，确保在各种输入情况下都能正确解析
 * 保持了与Location枚举的交互逻辑，符合地点标准化管理要求
 */
public class LocationString {
    private Location location;
    private String detail;
    private String locationString;

    public LocationString(Location location, String detail) {
        this.location = location;
        this.detail = detail;
        this.locationString = calculateLocationString(location, detail);
    }

    /**
     * 构造函数，用于直接从地点字符串中解析地点信息。
     * @param locationString 地点字符串
     */
    public LocationString(String locationString) {
        String[] parts = locationString.split(" ", 2);
        if (parts.length >= 1) {
            this.location = Location.fromChinese(parts[0].replaceAll("[\\[\\]]", ""));
            this.detail = parts.length > 1 ? parts[1] : "";
        } else {
            this.location = null;
            this.detail = "";
        }
        this.locationString = locationString;
    }

    private String calculateLocationString(Location location, String detail) {
        if (location == null) {
            return detail;
        }

        String locationName = location.getName();
        if (detail == null || detail.isEmpty()) {
            return "[" + locationName + "]";
        } else {
            return "[" + locationName + "] " + detail;
        }
    }

    /**
     * 用于获取地点字符串。
     */
    public String getString() {
        return locationString;
    }

    /**
     * 用于获取字符串中的地点前缀，返回值为枚举值。
     */
    public Location getLocationEnum() {
        return location;
    }

    /**
     * 用于获取字符串中的详细信息，返回值为字符串。
     */
    public String getLocationDetail(){
        return detail;
    }

    /**
     * 设置字符串中的详细信息。
     */
    public void setDetail(String detail) {
        this.detail = detail;
        this.locationString = calculateLocationString(location, detail);
    }

    /**
     * 设置字符串的前缀枚举值。
     */
    public void setLocation(Location location) {
        this.location = location;
        this.locationString = calculateLocationString(location, detail);
    }

    /**
     * 用于将LocationString对象转换为JSON字符串。
     * 强行给前端返回的JSON字符串中，地点信息以字符串的形式给出。
     * @return 地点字符串
     */
    @JsonValue
    @Override
    public String toString() {
        return locationString;
    }
}