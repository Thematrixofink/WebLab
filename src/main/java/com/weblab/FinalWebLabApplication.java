package com.weblab;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.weblab.system.mapper")
@SpringBootApplication
public class FinalWebLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalWebLabApplication.class, args);
    }

}
