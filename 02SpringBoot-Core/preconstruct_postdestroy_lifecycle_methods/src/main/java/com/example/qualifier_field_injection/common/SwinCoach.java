package com.example.qualifier_field_injection.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.qualifier_field_injection.iCoach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Primary
@Component
public class SwinCoach implements iCoach {

    @Override
    public String getName() {
       return "swim";
    }

     @PostConstruct
    public void post1(){
        System.out.println("Post construct 1 called ");
    }

     @PostConstruct
    public void post0(){
        System.out.println("Post construct 0 called ");
    }


     @PostConstruct
    public void post2(){
        System.out.println(" Post construct 2 called  2-1 when 2 1st");
    }

   
   

     @PreDestroy
    public void pre2(){
        System.out.println(" Pre destroy 2 called ");
    }

    @PreDestroy
    public void pre1(){
        System.out.println(" Pre destroy 1 called ");
    }
}
