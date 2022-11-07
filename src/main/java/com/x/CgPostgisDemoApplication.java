package com.x;

import com.x.config.generator.InsertBatch;
import com.x.mapper.ProvinceMapper;
import com.x.service.impl.ProvinceServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CgPostgisDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CgPostgisDemoApplication.class, args);
    }

}
