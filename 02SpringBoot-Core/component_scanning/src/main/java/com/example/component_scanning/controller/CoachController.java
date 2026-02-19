package com.example.component_scanning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    private Coach coach;

    public CoachController(Coach coa){
        this.coach=coa;
    }

    @GetMapping("/det")
    String getDetails(){
        return this.coach.getName();
    }

    
}
