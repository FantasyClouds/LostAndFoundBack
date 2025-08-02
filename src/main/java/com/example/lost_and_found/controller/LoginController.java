package com.example.lost_and_found.controller;

import com.example.lost_and_found.dao.dto.LoginRequest;
import com.example.lost_and_found.util.College;
import com.example.lost_and_found.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 */
@RestController
@Slf4j
public class LoginController {
    /**
     * 登录接口，接受前端的用户名和密码
     * account参数为id或者账号名。
     */
    @PostMapping("/login")
    public ResponseEntity<Response<Boolean>> register(
            @RequestBody LoginRequest loginRequest
            ) {
        log.info("login");
        Response<Boolean> response = new Response<>();
        // TODO: 登录逻辑
        // TODO: 调用service层的登录方法，返回登录成功与否。
        // TODO: 注意对LoginRequest判空


        response.status = HttpStatus.OK;
        response.msg = "登录成功";
        response.data = true;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
