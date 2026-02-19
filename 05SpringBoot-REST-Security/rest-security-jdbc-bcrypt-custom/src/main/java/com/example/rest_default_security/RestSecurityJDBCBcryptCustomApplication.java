package com.example.rest_default_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestSecurityJDBCBcryptCustomApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext app=SpringApplication.run(RestSecurityJDBCBcryptCustomApplication.class, args);
	  System.out.println(app.getBeanFactory().getBeanDefinitionNames());
	
	}

}
