package com.example.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalException {

    @ExceptionHandler
    public ResponseEntity<Object> handleAll (Exception e){
       return new ResponseEntity<>("In exception handler"+e,HttpStatus.EXPECTATION_FAILED);
    }
}
