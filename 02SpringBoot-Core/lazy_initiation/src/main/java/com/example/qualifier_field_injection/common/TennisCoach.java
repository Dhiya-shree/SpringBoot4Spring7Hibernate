package com.example.qualifier_field_injection.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.example.qualifier_field_injection.iCoach;

@Lazy
@Component
public class TennisCoach implements iCoach{

     @Override
    public String getName() {
       return "bats";
    }
}
