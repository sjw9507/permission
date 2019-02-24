package com.sjw.permission;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author sjw
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = {})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

