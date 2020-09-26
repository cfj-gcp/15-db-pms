package com.tedu.idea03maven;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tedu.idea03maven.mapper")//告诉mybatis框架给mapper包中的接口创建代理对象
public class Idea03mavenApplication {

    public static void main(String[] args) {
        SpringApplication.run(Idea03mavenApplication.class, args);
    }

}
