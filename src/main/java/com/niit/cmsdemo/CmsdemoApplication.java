package com.niit.cmsdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.niit.cmsdemo.dao")
public class CmsdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmsdemoApplication.class, args);
	}
}
