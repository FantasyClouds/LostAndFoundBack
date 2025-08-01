package com.example.lost_and_found;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.lost_and_found.dao.mapper")
@SpringBootApplication
public class Test1Application {
    // main method
    public static void main(String[] args) {
        SpringApplication.run(Test1Application.class, args);
    }
}
