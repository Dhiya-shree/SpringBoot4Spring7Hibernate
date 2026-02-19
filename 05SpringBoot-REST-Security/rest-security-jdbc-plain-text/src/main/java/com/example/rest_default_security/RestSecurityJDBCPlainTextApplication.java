package com.example.rest_default_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestSecurityJDBCPlainTextApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext app=SpringApplication.run(RestSecurityJDBCPlainTextApplication.class, args);
	  String beans[]=app.getBeanFactory().getBeanDefinitionNames();
	   for (String string : beans) {
	     System.out.println(string+app.getBean(string));
	   }
	}

}
