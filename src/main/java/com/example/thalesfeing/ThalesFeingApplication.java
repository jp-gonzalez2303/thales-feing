package com.example.thalesfeing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ThalesFeingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThalesFeingApplication.class, args);
    }

}
