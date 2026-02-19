package com.example.rest.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.customException.StudentNotFoundException;
import com.example.rest.entity.Student;
import com.example.rest.errorResponse.StudentErrorResponse;

import jakarta.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> students;

        // PostConstruct to load data 
        @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("AA", "BB"));
        students.add(new Student("AA2", "BB2"));
        students.add(new Student("AA3", "BB3"));
    }



    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getMethodName(@PathVariable Integer studentId) {
        return students.get(studentId);
    }

     @GetMapping("/students/customExe/{studentId}")
    public Student getMethodNameException(@PathVariable Integer studentId) {
        
        if(studentId>=students.size() || studentId<0){
            throw new StudentNotFoundException(" Student ID not found "+studentId);
        }

        return students.get(studentId);
    }
    
     @GetMapping("/students/commonExe/{studentId}")
    public Student getMethodNameExceptionCommon(@PathVariable Integer studentId) {
        
        if(studentId>=students.size() || studentId<0){
            throw new StudentNotFoundException("123");
        }

        return students.get(studentId);
    }


    
@ExceptionHandler
public ResponseEntity<StudentErrorResponse> handleAllException(Exception ex){
     StudentErrorResponse error = new StudentErrorResponse();
    error.setStatus(HttpStatus.NOT_FOUND.value());
    error.setMessage(ex.getMessage()+" All exception handled for contrller ");
    error.setTimeStamp(System.currentTimeMillis());
    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
}

// Controller specific Exception handler 
@ExceptionHandler
public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex){
    StudentErrorResponse error = new StudentErrorResponse();
    error.setStatus(HttpStatus.NOT_FOUND.value());
    error.setMessage(ex.getMessage()+" Student Not Found ");
    error.setTimeStamp(System.currentTimeMillis());
    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
}




}
