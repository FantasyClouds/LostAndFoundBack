package com.example.lost_and_found.controller;

import com.example.lost_and_found.config.FileStorageProperties;
import com.example.lost_and_found.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * 用于上传图片的控制器。
 * 上传的图片为临时图片，需要关联到数据库之后转正。
 */
@RestController
@Slf4j
public class ImgUploadController {
    @Value("${file.upload-img-dir}")
    private String uploadDir;
    private final FileStorageProperties storageProps;

    @Autowired
    public ImgUploadController(FileStorageProperties storageProps) {
        this.storageProps = storageProps;
    }

    /**
     * 上传图片的接口。
     * 返回储存图片的url
     * 上传的是临时图片，后续会关联到数据库。
     */
    @PostMapping(value = "/upload/img", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Response<String>> uploadImg(
            @RequestPart("file") MultipartFile file
    ){
        log.info("uploadImg()");
        Response<String> response = new Response<>();
        // 配置存储路径（可放在application.properties）
        try {
            // 校验文件
            validateFile(file);

            // 生成安全文件名
            String fileName = generateSecureFileName(file);

            // 存储路径处理
            Path targetPath = prepareStoragePath(fileName);

            // 执行文件转移
            file.transferTo(targetPath);

            // 构建访问URL
            String fileUrl = uploadDir + fileName;

            response.status = HttpStatus.OK;
            response.msg = "上传成功";
            response.data = fileUrl;
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (IllegalArgumentException | IOException e) {
            response.status = HttpStatus.BAD_REQUEST;
            response.msg =e.getMessage();
            return ResponseEntity.badRequest().body(response);
        }
    }
    // 校验文件
    private void validateFile(MultipartFile file) {
        // 空文件校验
        if (file.isEmpty()) {
            throw new IllegalArgumentException("上传文件不能为空");
        }

        // 文件类型校验
        if (!storageProps.getAllowTypes().contains(file.getContentType())) {
            throw new IllegalArgumentException("仅支持" + storageProps.getAllowTypes() + "格式");
        }

        // 文件大小校验
        if (file.getSize() > storageProps.getMaxSize().toBytes()) {
            String maxSizeMB = storageProps.getMaxSize().toMegabytes() + "MB";
            throw new IllegalArgumentException("文件大小超过" + maxSizeMB + "限制");
        }
    }
    //生成唯一文件名
    private String generateSecureFileName(MultipartFile file) {
        // 生成唯一前缀
        String uuid = UUID.randomUUID().toString().replace("-", "");

        // 获取原始文件名并消毒处理
        String originalName = StringUtils.cleanPath(file.getOriginalFilename());

        // 提取扩展名
        String ext = StringUtils.getFilenameExtension(originalName);
        ext = StringUtils.hasText(ext) ? "." + ext : "";

        return uuid + "_" + System.currentTimeMillis() + ext;
    }
    //准备路径
    private Path prepareStoragePath(String fileName) throws IOException {
        Path storageDir = Paths.get(storageProps.getTempDir())
                .toAbsolutePath()
                .normalize();

        // 自动创建目录
        Files.createDirectories(storageDir);

        return storageDir.resolve(fileName);
    }
}
