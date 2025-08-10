package com.example.lost_and_found.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * 处理图片上传业务逻辑
 */
@Service
@Slf4j
public class ImgUploadService {
    @Value("${file.upload-img-dir:.temp/uploads/images/}")
    private String uploadImgDir;

    /**
     * 上传图片，将图片保存到临时目录，并返回访问URL
     * 临时目录是未连接到数据库的目录，会定时清楚。
     */
    public String uploadImg(MultipartFile file) {
        try {
            // 生成唯一文件名
            String originalFilename = file.getOriginalFilename();
            String fileExtension = null;
            if (originalFilename != null) {
                fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
            }
            String newFilename = UUID.randomUUID() + fileExtension;

            // 如果没有上传目录，则创建存储目录
            Path uploadPath = Paths.get(uploadImgDir);
            if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
            }
            // 保存文件
            Path filePath = uploadPath.resolve(newFilename);
            file.transferTo(filePath);

            // 构造访问URL（生产环境需替换为绝对地址）
            return "temp/uploads/images/" + newFilename;
        } catch (IOException e) {
            log.error("文件存储失败", e);
            return null;
        }
    }
}
