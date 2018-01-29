package com.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = { "com.todo.repository" })
@EntityScan("com.todo.domain")
@ComponentScan(basePackages = { "com.todo.controllers", "com.todo.service", "com.todo.domain",
		"com.todo.repository" })
public class ToDoApplication {
	public static void main(String[] args) {
		SpringApplication.run(ToDoApplication.class, args);
	}
}
