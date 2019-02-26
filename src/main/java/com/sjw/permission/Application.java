package com.sjw.permission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author sjw
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = {"com.sjw.permission.modules.*.dao","com.sjw.permission.modules.*.mapper"})

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

