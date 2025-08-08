package com.example.lost_and_found.util;


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
}
