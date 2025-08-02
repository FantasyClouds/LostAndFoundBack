package com.example.lost_and_found.service;

import com.example.lost_and_found.util.College;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用于处理用户注册业务逻辑
 * 包含判断用户名是否已存在、密码是否符合要求、注册用户到数据库等功能
 */
@Service
@Slf4j
public class SignUpService {
    /**
     * 注册主方法，返回注册结果信息。成功则返回“注册成功”，失败则返回具体失败原因。
     * 当发现用户名、手机号、学号已存在时，请抛出异常，并返回原因字符串。
     */
    public String signUp(Long id, String name, String password, String real_name,
                         String type, String phone, College college) {
        log.info("signUp()");
        //TODO 实现注册业务逻辑
        //TODO 要在失败的地方添加日志

        return "注册成功";
    }
    /**
     * 判断用户名是否已存在
     */
    public Boolean isNameExist(String name) {
        log.info("isNameExist()");
        //TODO 判断用户名是否已存在，存在则抛出UserNameAlreadyExistsException
        //TODO 要在失败的地方添加日志

        return false;
    }
    /**
     * 判断密码是否符合要求
     * 判断规则：长度至少8位，包含数字、字母
     */
    public Boolean isPasswordValid(String password) {
        log.info("isPasswordValid()");
        //TODO 判断密码是否符合要求，不符合要求抛出UserPasswordIllegalException
        //TODO 要在失败的地方添加日志

        return true;
    }
    /**
     * 判断手机号是否已注册
     */
    public Boolean isPhoneExist(String phone) {
        log.info("isPhoneExist()");
        //TODO 判断手机号是否已注册，存在则抛出UserPhoneAlreadyExistsException
        //TODO 要在失败的地方添加日志

        return false;
    }
    /**
     * 判断学/工号是否已经注册
     */
    public Boolean isIdExist(Long id) {
        log.info("isIdExist()");
        //TODO 判断学/工号是否已经注册，存在则抛出UserIdAlreadyExistsException
        //TODO 要在失败的地方添加日志

        return false;
    }
    /**
     * 注册用户到数据库，在这里区分用户类型
     */
    public void registerUser(Long id, String name, String password, String real_name,
                            String type, String phone, College college) {
        log.info("registerUser()");
        //TODO 注册用户到数据库
        //TODO 要在失败的地方添加日志
        //TODO 区分用户类型，调用Dao层的注册逻辑


    }
}
