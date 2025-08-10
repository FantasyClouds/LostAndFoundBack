package com.example.lost_and_found.util;


import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 标准地点字符串工具类。
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
     * @param locationString
     */
    public LocationString(String locationString) {
        String[] parts = locationString.split(" ", 2);
        if (parts.length == 1) {
            this.location = Location.fromChinese(parts[0]);
            this.detail = "";
        }
        this.locationString = locationString;
    }

    private String calculateLocationString(Location location, String detail) {
        this.location = location;
        this.detail = detail;
        String string = location.getName();
        if (detail == null || detail.isEmpty()) {
            this.locationString = "[" + string + "]";
        } else {
            this.locationString = "[" + string + "] " + detail;
        }
        return string;
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
     * @return
     */
    @JsonValue
    @Override
    public String toString() {
        return locationString;
    }
}
