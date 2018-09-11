package com.jesse.jesseweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.jesse.mapper")
public class JesseWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(JesseWebApplication.class, args);
	}
}
