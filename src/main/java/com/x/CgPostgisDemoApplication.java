package com.x;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.x.mapper")
public class CgPostgisDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CgPostgisDemoApplication.class, args);
    }

}
