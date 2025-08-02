package com.example.lost_and_found.dao;

import com.example.lost_and_found.util.College;
import lombok.extern.slf4j.Slf4j;

/**
 * 数据库操作类
 * 用于注册用户到数据库
 */
@Slf4j
public class RegisterDao {
    /**
     * 注册用户到数据库
     */
    public void registerUser(Long user_id, String user_name, String user_password,
                             String user_real_name, String user_phone, College user_college) {
        log.info("registerUser()");
        //TODO 使用Mappers将用户信息插入数据库

    }
}
