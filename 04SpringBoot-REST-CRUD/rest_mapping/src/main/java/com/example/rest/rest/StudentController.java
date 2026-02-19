package com.example.rest.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.entity.Student;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
    public Student getMethodName(@RequestParam Integer studentId) {
        return students.get(studentId);
    }
    
    
}
