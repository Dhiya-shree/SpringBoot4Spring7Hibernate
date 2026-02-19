package com.example.mvc0_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FormController {

    @GetMapping("/showForm")
    public String shoMethodName() {
        return "helloworld-form";
    }
     @GetMapping("/processForm")
    public String requestMethodName() {
        return "helloworld";
    }


    
}
