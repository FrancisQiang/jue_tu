package com.tf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.tf.dao")
public class JueTuApplication {

    public static void main(String[] args) {
        SpringApplication.run(JueTuApplication.class, args);
    }

}
