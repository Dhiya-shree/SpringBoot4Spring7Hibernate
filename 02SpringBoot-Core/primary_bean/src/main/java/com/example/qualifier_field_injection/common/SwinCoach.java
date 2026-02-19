package com.example.qualifier_field_injection.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.qualifier_field_injection.iCoach;

@Primary
@Component
public class SwinCoach implements iCoach {

    @Override
    public String getName() {
       return "swim";
    }

}
