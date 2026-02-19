package com.example.rest.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/test")//use request mapping , methods can be any Put,Post,Get
public class DemoController {

    @GetMapping("hello")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("error/{val}")
    public int sayError(@PathVariable String val) {
        System.out.println(" Will the exception handler work here ? ");
        return Integer.parseInt(val);
    }
    
}
