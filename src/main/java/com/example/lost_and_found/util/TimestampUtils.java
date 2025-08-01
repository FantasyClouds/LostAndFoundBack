package com.example.lost_and_found.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 用于转换时间戳的工具类
 */
public class TimestampUtils {
    private static final DateTimeFormatter DEFAULT_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // 带时区转换的通用方法
    public static String convertTimestamp(String timestampStr, String zoneId) {
        long epochSecond = Long.parseLong(timestampStr);
        ZoneId zone = ZoneId.of(zoneId);
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(epochSecond), zone)
                .format(DEFAULT_FORMATTER);
    }
}
