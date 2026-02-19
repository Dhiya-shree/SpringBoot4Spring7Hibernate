package com.example.rest.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.rest.errorResponse.StudentErrorResponse;
import com.example.rest.customException.StudentNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentException(StudentNotFoundException exc){

        StudentErrorResponse stu=new StudentErrorResponse();
        stu.setMessage(exc.getMessage()+" In the controller Advice ");
        stu.setStatus(HttpStatus.BAD_REQUEST.value());
        stu.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(stu,HttpStatus.BAD_REQUEST);
    }

     @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAllException(Exception exc){

        StudentErrorResponse stu=new StudentErrorResponse();
        stu.setMessage(exc.getMessage()+" In the controller Advice all exceptions ");
        stu.setStatus(HttpStatus.BAD_REQUEST.value());
        stu.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(stu,HttpStatus.BAD_REQUEST);
    }
}









