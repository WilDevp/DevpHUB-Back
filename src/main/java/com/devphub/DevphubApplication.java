package com.devphub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DevphubApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevphubApplication.class, args);
    }

}
