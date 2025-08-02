package com.example.lost_and_found.controller;

import com.example.lost_and_found.util.College;
import com.example.lost_and_found.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SignUpController {
    /**
     * 根据传入的RequesParam，进行注册操作。
     * 需对注册信息进行校验，如密码长度、用户名是否已存在等。
     * 注册成功后，返回注册成功的消息。
     */
    @PostMapping("/register")
    public ResponseEntity<Response<Boolean>> register(
            @RequestParam(required = true) Long id,
            @RequestParam(required = true) String name,
            @RequestParam(required = true) String password,
            @RequestParam(required = true) String real_name,
            @RequestParam(required = true) String type,
            @RequestParam(required = true) String phone,
            @RequestParam(required = true) College college
    ) {
        log.info("register");
        Response<Boolean> response = new Response<>();
        // TODO: 校验注册信息，如密码长度、用户名是否已存在等。
        // TODO: 调用service层进行注册操作。

        response.status = HttpStatus.OK;
        response.msg = "注册成功";
        response.data = true;

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
