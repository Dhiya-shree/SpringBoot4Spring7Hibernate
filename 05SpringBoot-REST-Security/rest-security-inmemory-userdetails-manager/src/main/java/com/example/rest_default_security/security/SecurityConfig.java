package com.example.rest_default_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userManager(){

        UserDetails user1=User.builder().username("user1").password("{noop}pass")
                            .roles("EMPLOYEE").build();
        UserDetails user2=User.builder().username("user2").password("{noop}pass")
                             .roles("EMPLOYEE","MANAGER").build();
        UserDetails user3=User.builder().username("user3").password("{noop}pass")
                             .roles("EMPLOYEE","MANAGER","ADMIN").build();

        return new InMemoryUserDetailsManager(user1,user2,user3);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer->
        configurer.requestMatchers(HttpMethod.POST,"/api/emp/**").hasAnyRole("MANAGER","EMPLOYEE")
        .requestMatchers(HttpMethod.DELETE,"/api/emp/**").hasAnyRole("ADMIN","MANAGER")
        .requestMatchers(HttpMethod.PUT,"/api/emp/**").hasAnyRole("ADMIN","MANAGER")
        .requestMatchers("/**").permitAll());

        http.formLogin(form-> form.loginPage("/login").permitAll());

        http.logout(LogoutConfigurer::permitAll);

        // use HTTP basic authentication 
        http.httpBasic(Customizer.withDefaults());

        // Disable cross site request forgery 
        // Not needed for stateless REST API 
        http.csrf(csrf->csrf.disable());

        return http.build();
    }
}
