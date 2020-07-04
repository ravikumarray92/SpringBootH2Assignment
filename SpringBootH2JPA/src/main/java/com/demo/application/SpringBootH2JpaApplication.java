package com.demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({ "com.demo.repository", "com.demo.application", "com.demo.configuration", "com.demo.controllers",
		"com.demo.dao", "com.demo.entity", "com.demo.service", "com.demo.model" })
public class SpringBootH2JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootH2JpaApplication.class, args);
	}

}
