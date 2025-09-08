package com.example.lost_and_found.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于和用户数据相关的前后端接口
 */
@RestController
@Slf4j
public class UserDataController {
    /**
     * 用于从服务器获取用户账号名的接口，传入数据为
     */
    @GetMapping("/userdata/name")
    public String getUserName(
            @RequestParam(value = "user_id", required = true) Long user_id
    ) {
        log.info("getUserName()");


        return "张三";
    }

}
