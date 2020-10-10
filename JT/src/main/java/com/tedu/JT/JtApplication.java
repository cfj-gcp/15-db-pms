package com.tedu.JT;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tedu.JT.mapper")
public class JtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JtApplication.class, args);
	}

}
