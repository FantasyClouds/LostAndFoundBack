package com.example.lost_and_found.controller;

import com.example.lost_and_found.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用于上传图片的控制器。
 * 上传的图片为临时图片，需要关联到数据库之后转正。
 */
@RestController
@Slf4j
public class ImgUploadController {


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
        // TODO: 上传图片逻辑
        // 配置存储路径（可放在application.properties）
        try {
            // 校验文件
            if (file.isEmpty()) {
                throw new IllegalArgumentException("文件不能为空");
            }

            response.status = HttpStatus.OK;
            response.msg = "上传成功";
            response.data = "";
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (IllegalArgumentException e) {
            response.status = HttpStatus.BAD_REQUEST;
            response.msg =e.getMessage();
            return ResponseEntity.badRequest().body(response);
        }


    }
}
