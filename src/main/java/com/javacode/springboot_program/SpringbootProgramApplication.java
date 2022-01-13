package com.javacode.springboot_program;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.javacode.springboot_program.mapper")
@EnableTransactionManagement
public class SpringbootProgramApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootProgramApplication.class, args);
    }

}
