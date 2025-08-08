package com.example.lost_and_found.service;

import com.example.lost_and_found.dao.PublishItemDao;
import com.example.lost_and_found.dao.dto.PublishItemDto;
import com.example.lost_and_found.dao.dto.PublishItemRequest;
import com.example.lost_and_found.util.FileMover;
import com.example.lost_and_found.util.IdGenerator;
import com.example.lost_and_found.util.LocationString;
import io.jsonwebtoken.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;

/**
 * 发布物品逻辑业务，将物品信息发布到平台上
 */
@Service
@Slf4j
public class PublishItemService {
    @Value("${file.found_unfinished-img-dir}")
    private String found_unfinished_img_dir;
    private final IdGenerator idGenerator;
    private final FileMover fileMover;
    private final PublishItemDao publishItemDao;
    // 依赖注入
    @Autowired
    public PublishItemService(IdGenerator idGenerator, FileMover fileMover, PublishItemDao publishItemDao) {
        this.idGenerator = idGenerator;
        this.fileMover = fileMover;
        this.publishItemDao = publishItemDao;
    }
    /**
     * 发布物品，讲图片移到正式目录，并关联到数据库。
     * 同时创造物品的唯一标识符。
     */
    public void publishItem(PublishItemRequest request){
        //TODO 实现发布物品逻辑
        //TODO 移动图片到正式目录
        //TODO 关联物品到数据库
        //TODO 生成物品的唯一标识符
        log.info("publishItem()");
        try {
            validateRequest(request);
            Long itemId = idGenerator.nextId(request.getType());
            LocationString locationString = new LocationString(request.getFound_location(), request.getFound_location_detail());
            // 转移图片并生成新路径
            String newImagePath = transferImages(request.getImgUrl(), itemId);

            //生成物品Dto类，调用Dao层注入到数据库中
            PublishItemDto item = new PublishItemDto(
                    itemId,
                    request.getName(),
                    request.getDescription(),
                    request.getType(),
                    locationString.getString(),
                    request.getColor(),
                    request.getImgUrl(),
                    request.getPublish_time(),
                    request.getFound_time()
            );
            // 持久化到数据库
            publishItemDao.publishItem(item);
            log.info("物品发布成功：ID={}", itemId);

        } catch (IOException | java.io.IOException e) {

        }
    }
    // 验证请求参数
    private void validateRequest(PublishItemRequest request) {
        if(request.getColor().isEmpty()){
            throw new IllegalArgumentException("PublishItemService:color is empty");
        } else if(request.getImgUrl().isEmpty() || request.getImgUrl() == null){
            throw new IllegalArgumentException("PublishItemService: imgUrl is empty");
        } else if(request.getName().isEmpty() || request.getName() == null){
            throw new IllegalArgumentException("PublishItemService: name is empty");
        } else if(request.getPublish_time() == null){
            throw new IllegalArgumentException("PublishItemService: publish_time is empty");
        }
    }
    // 转移图片到正式目录
    private String transferImages(String tempImagePath, Long itemId) throws IOException, java.io.IOException {
        // 生成唯一文件名（示例：12345_original.jpg）
        String fileName = itemId + "_" + Paths.get(tempImagePath).getFileName();

        // 执行文件转移
        return fileMover.moveFile(
                tempImagePath,
                found_unfinished_img_dir, // 正式目录
                fileName
        );
    }
}
