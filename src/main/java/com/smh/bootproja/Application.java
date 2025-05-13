package com.smh.bootproja;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.smh")
@MapperScan("com.smh.bootproja")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}

