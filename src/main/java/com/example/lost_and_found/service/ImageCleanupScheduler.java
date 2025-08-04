package com.example.lost_and_found.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 定时清理临时上传，未关联到数据库的图片
 */
@Component
@Slf4j
public class ImageCleanupScheduler {

    // 从配置读取清理参数
    @Value("${cleanup.directory:.temp/uploads/images/}")
    private String targetDirectory;

    @Value("${cleanup.max-age-hours:72}")
    private int maxAgeHours;

    @Value("${cleanup.file-extensions:.jpg,.png,.jpeg,.gif}")
    private Set<String> targetExtensions;

    // 每天凌晨4点执行（可通过配置覆盖）
    @Scheduled(cron = "${cleanup.cron:0 0 4 * * *}")
    public void cleanExpiredImages() {
        Path dir = Paths.get(targetDirectory);

        if (!Files.exists(dir)) {
            log.warn("目标清理目录不存在: {}", dir.toAbsolutePath());
            return;
        }

        try (Stream<Path> pathStream = Files.walk(dir)) {
            pathStream
                    .filter(this::isTargetFile)
                    .filter(this::isExpiredFile)
                    .forEach(this::safeDelete);
        } catch (IOException e) {
            log.error("目录遍历失败: {}", e.getMessage());
        }
    }

    private boolean isTargetFile(Path path) {
        return !Files.isDirectory(path) &&
                targetExtensions.contains(getFileExtension(path).toLowerCase());
    }

    private boolean isExpiredFile(Path path) {
        try {
            FileTime lastModified = Files.getLastModifiedTime(path);
            Duration age = Duration.between(lastModified.toInstant(), Instant.now());
            return age.toHours() >= maxAgeHours;
        } catch (IOException e) {
            log.error("获取文件时间失败: {}", path, e);
            return false;
        }
    }

    private void safeDelete(Path path) {
        try {
            Files.delete(path);
            log.info("已删除过期文件: {}", path);
            // 可选：删除空目录
            deleteParentIfEmpty(path.getParent());
        } catch (NoSuchFileException e) {
            log.warn("文件已被删除: {}", path);
        } catch (IOException e) {
            log.error("文件删除失败: {}", path, e);
        }
    }

    private void deleteParentIfEmpty(Path dir) throws IOException {
        if (dir != null && Files.isDirectory(dir)) {
            try (Stream<Path> entries = Files.list(dir)) {
                if (!entries.findAny().isPresent()) {
                    Files.delete(dir);
                    log.info("已删除空目录: {}", dir);
                }
            }
        }
    }

    private String getFileExtension(Path path) {
        String fileName = path.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex);
    }
}