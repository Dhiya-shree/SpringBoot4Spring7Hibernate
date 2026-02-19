package com.spring.overview.application01.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerClass {

    //inject properties 
    @Value("${coach.name}")
    private String coachNameu;

    @Value("${class.name}")
    private String className;

    // expose "/" that return Hello World 
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/classDet")
    public String getClassDet(){
        return (className+" ----  "+coachNameu);
    }

}
