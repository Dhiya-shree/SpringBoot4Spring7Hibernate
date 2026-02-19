package com.example.mvc0_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerClass {

    @GetMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute(
           "theDate",java.time.LocalDateTime.now()
        );
        return "helloworld";
    }
}
