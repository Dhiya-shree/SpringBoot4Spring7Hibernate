package com.example.constructor_injection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerCoack {

    private Coach coach;

    public ControllerCoack(Coach coach){
        this.coach=coach;
    }

    @GetMapping("/details")
    public String getCoachDetails(){
        return this.coach.getName();
    }
}
