package com.example.qualifier_field_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class selectCoach {

    //Field Injection Qualifier 
    @Autowired
    private iCoach coach2;

    //Construction Injection Qualifier 
    private iCoach coach;

    private iCoach coach3;

    public selectCoach(@Qualifier("cricketCoach") iCoach coach){
        this.coach=coach;
    }

    @GetMapping("/const")
    public String getCoach(){
        return coach.getName()+" const injection lazzy?";
    }

    @GetMapping("/feild")
    public String getCoachFieldInjection(){
        return coach2.getName()+" feild Primary injection lazy? ";
    }

    @GetMapping("/setter")
    public String getCoachSetterInjection(){
        return coach3.getName()+" setter injection lazy?";
    }

    @Autowired
    @Qualifier("tennisCoach")
    public void setCoach3(iCoach coach3){
        this.coach3 = coach3;
    }

    

}
