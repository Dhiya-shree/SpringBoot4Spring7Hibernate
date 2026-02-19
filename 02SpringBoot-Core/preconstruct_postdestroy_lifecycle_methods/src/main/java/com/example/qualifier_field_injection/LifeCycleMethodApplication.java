package com.example.qualifier_field_injection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@SpringBootApplication
public class LifeCycleMethodApplication {

	public static void main(String[] args) {
		SpringApplication.run(LifeCycleMethodApplication.class, args);
	}

	@PreDestroy
    public void mainMethodPre1(){
    System.out.println(" Main Pre Destroy -----");
    }

     @PostConstruct
	 public void post3(){
		System.out.println(" Main Post Construct ----");
	 }

}

