package com.gosopt.seminarapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.gosopt.seminardomain")
public class ApiApplication {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application,api");
        SpringApplication.run(ApiApplication.class, args);
    }
}
