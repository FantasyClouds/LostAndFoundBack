package com.example.test1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.test1.dao")
@EntityScan("com.example.test1.dao.entity")
@SpringBootApplication
public class Test1Application {
    // This is the main method of the application.


    public static void main(String[] args) {
        SpringApplication.run(Test1Application.class, args);
    }

}
