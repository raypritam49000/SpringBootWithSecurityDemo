package com.security.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@EnableSwagger2
public class SpringBootJpaRestApiJwtDemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaRestApiJwtDemoApplication.class, args);
	}


}
