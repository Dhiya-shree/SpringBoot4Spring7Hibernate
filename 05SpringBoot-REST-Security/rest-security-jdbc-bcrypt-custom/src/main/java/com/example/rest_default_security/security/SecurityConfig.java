package com.example.rest_default_security.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;                                                                     
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");
        return jdbcUserDetailsManager;
    }


    /*@Bean
    public InMemoryUserDetailsManager userManager(){

        UserDetails user1=User.builder().username("user1").password("{noop}pass")
                            .roles("EMPLOYEE").build();
        UserDetails user2=User.builder().username("user2").password("{noop}pass")
                             .roles("EMPLOYEE","MANAGER").build();
        UserDetails user3=User.builder().username("user3").password("{noop}pass")
                             .roles("EMPLOYEE","MANAGER","ADMIN").build();

        return new InMemoryUserDetailsManager(user1,user2,user3);
    }
        */

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer->
        configurer.
        dispatcherTypeMatchers(DispatcherType.FORWARD,DispatcherType.ERROR,DispatcherType.INCLUDE,
        DispatcherType.REQUEST,DispatcherType.ASYNC).permitAll()
        .requestMatchers("/api/emp/**").authenticated()
        .anyRequest().permitAll());

       //// http.formLogin(form-> form.loginPage("/login").permitAll());

        //http.logout(LogoutConfigurer::permitAll);

        // use HTTP basic authentication 
        http.httpBasic(Customizer.withDefaults());

        // Disable cross site request forgery 
        // Not needed for stateless REST API 
        http.csrf(csrf->csrf.disable());

        return http.build();
    }
}
