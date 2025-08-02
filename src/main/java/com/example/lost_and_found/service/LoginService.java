package com.example.lost_and_found.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 登录业务类
 */
@Service
@Slf4j
public class LoginService {
    /**
     * 登录业务逻辑，需要对account参数进行分支处理。
     * account参数为id或者账号名。
     * 登录失败时请抛出异常，返回原因字符串
     * @param account
     * @param password
     * @return true or false
     */
    public Boolean login(String account, String password) {
        log.info("login()");
        //TODO: 登录业务主逻辑
        //TODO: 根据account参数判断是账号名还是id，对name参数进行分支处理
        //TODO: 登录成功时返回true，登录失败时抛出异常，返回原因字符串
        //TODO: 由于登录只进行简单查询，因此允许在此直接使用Mapper进行查询。

        return true;
    }

    /**
     * 判断name参数是否为id
     * @param account
     * @return
     */
    public Boolean ifAccountIsId(String account) {
        log.info("ifNameIsId()");
        //TODO: 判断name参数是否为id
        //TODO: 如果name参数为id，返回true，否则返回false


        return true;
    }
    /**
     * 账号名是否存在
     */
    public Boolean ifNameExists(String name) {
        log.info("ifNameExists()");
        //TODO: 判断账号名是否存在
        //TODO: 如果账号名存在，不存在抛出


        return true;
    }
    /**
     * 判断id是否存在
     */
    public Boolean ifIdExists(String id) {
        log.info("ifIdExists()");
        //TODO: 判断id是否存在
        //TODO: 如果id存在，返回true，否则返回false

        return true;
    }
    /**
     * 密码是否正确
     */
    public Boolean ifPasswordCorrect(String name, String password) {
        log.info("ifPasswordCorrect()");
        //TODO: 判断密码是否正确
        //TODO: 如果密码正确，返回true，否则返回false

        return true;
    }
}
