package com.example.autumn_valley_agriculture;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.autumn_valley_agriculture.mapper")
public class AutumnValleyAgricultureApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutumnValleyAgricultureApplication.class, args);
    }

}
