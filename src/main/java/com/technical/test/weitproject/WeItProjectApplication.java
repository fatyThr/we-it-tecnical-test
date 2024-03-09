package com.technical.test.weitproject;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API Documentation",
				description = "Spring Boot REST API Documentation",
				version = "v1.0"
		)
)
@SpringBootApplication
public class WeItProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeItProjectApplication.class, args);
	}

}
