package com.example.component_scanning.controller;

import org.springframework.stereotype.Component;

@Component
public class CoachName implements Coach {

    @Override
    public String getName() {
        return "nameu";
    }
     
    
}
