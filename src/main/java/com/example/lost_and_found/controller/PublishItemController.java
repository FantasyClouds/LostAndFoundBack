package com.example.lost_and_found.controller;

import com.example.lost_and_found.dao.dto.PublishItemRequest;
import com.example.lost_and_found.service.PublishItemService;
import com.example.lost_and_found.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员发布物品控制器
 */
@RestController
@Slf4j
public class PublishItemController {

    @Autowired
    private final PublishItemService publishItemService;

    public PublishItemController(PublishItemService publishItemService) {
        this.publishItemService = publishItemService;
    }

    /**
     * 发布接口，接受前端的物品信息
     * 注意图片上传使用的是url，在此接口之前要先上传图片到服务器并获取到url
     */
    @PostMapping("/upload/adminItem")
    public ResponseEntity<Response<Boolean>> publishItem(
            @RequestBody PublishItemRequest publishItemRequest
    ){
        log.info("publishItem()");
        Response<Boolean> response = new Response<>();
        // TODO: 发布逻辑
        // TODO: 调用service层的发布方法，返回成发布功与否。
        // TODO: 注意对publishItemRequest判空
        try{
            publishItemService.publishItem(publishItemRequest);
        } catch (Exception e){

        }


        response.status = HttpStatus.OK;
        response.msg = "发布成功";
        response.data = true;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
