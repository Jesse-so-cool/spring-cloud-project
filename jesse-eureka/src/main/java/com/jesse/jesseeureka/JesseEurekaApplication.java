package com.jesse.jesseeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class JesseEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JesseEurekaApplication.class, args);
	}
}
