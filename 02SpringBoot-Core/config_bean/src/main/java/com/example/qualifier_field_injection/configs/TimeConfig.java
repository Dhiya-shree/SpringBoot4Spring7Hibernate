package com.example.qualifier_field_injection.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

@Configuration
public class TimeConfig {


    @Bean
    @Primary
    @Lazy
    public String time(){
       return "8 am - 6 pm ";
    }

    @Bean
    @Qualifier("SwimTime")
    public String timeSwim(){
        return "6 am - 1 pm ";
    }
}
