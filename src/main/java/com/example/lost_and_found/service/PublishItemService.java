package com.example.lost_and_found.service;

import com.example.lost_and_found.dao.dto.PublishItemRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 发布物品逻辑业务，将物品信息发布到平台上
 */
@Service
@Slf4j
public class PublishItemService {
    /**
     * 发布物品，讲图片移到正式目录，并关联到数据库。
     * 同时创造物品的唯一标识符。
     */
    public void publishItem(PublishItemRequest request) {
        //TODO 实现发布物品逻辑
        //TODO 移动图片到正式目录
        //TODO 关联物品到数据库
        //TODO 生成物品的唯一标识符


    }
}
