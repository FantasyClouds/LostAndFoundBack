package com.example.lost_and_found.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.nio.file.*;

/**
 * 转移文件的工具类
 */
@Slf4j
@Component
public class FileMover {
    /**
     * 转移文件到目录
     * @param sourcePath 源文件路径（完整绝对路径）
     * @param targetDir  目标目录（如：/data/images/）
     * @param fileName   新文件名
     * @return 新的完整存储路径
     */
    public String moveFile(String sourcePath, String targetDir, String fileName) throws IOException {
        Path source = Paths.get(sourcePath);
        Path targetDirectory = Paths.get(targetDir);

        // 自动创建目标目录
        Files.createDirectories(targetDirectory);

        // 构建目标路径（例如：/files/images/12345_photo.jpg）
        Path target = targetDirectory.resolve(fileName);

        // 执行原子性文件转移（自动覆盖已存在文件）
        Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);

        log.info("文件转移成功：{} -> {}", source, target);
        return target.toString();
    }
}
