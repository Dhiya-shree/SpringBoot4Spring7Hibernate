package com.example.constructor_injection;

import org.springframework.stereotype.Component;

@Component
public class SwinCoach implements Coach{

    @Override
    public String getName() {
        return "Swimming class";
    }

    

}
