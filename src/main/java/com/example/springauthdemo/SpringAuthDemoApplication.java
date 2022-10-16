package com.example.springauthdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { ErrorMvcAutoConfiguration.class })
@ComponentScan(basePackages = { "com.example.springauthdemo" })
@EntityScan("com.example.springauthdemo.model")
@EnableJpaRepositories("com.example.springauthdemo.repository")
public class SpringAuthDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAuthDemoApplication.class, args);
	}

}
