package com.example.rest.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/test")//use request mapping , methods can be any Put,Post,Get
public class DemoController {

    @GetMapping("hello")
    public String sayHello() {
        return "Hello World!";
    }
    
}
