package com.example.user_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class UserProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProjectApplication.class, args);
    }

}
