package com.example.rest_default_security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest_default_security.entity.Employee;
import com.example.rest_default_security.repository.EmployeeRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/emp")
public class EmloyeeRestController {

    private EmployeeRepository employeeRepository;
    
    public EmloyeeRestController(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @PostMapping("/employees")
    public String postMethodName(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return "Add success";
    }
    
    @PutMapping("/employees/{id}")
    public String putMethodName(@PathVariable Integer id, @RequestBody Employee emp) {
        employeeRepository.save(emp);
        return "updated "+id+ " successfully ";
    }
   
    @DeleteMapping("employees/{id}")
    public String deleteMethod(@PathVariable Integer id){
       
        Employee emp=employeeRepository.findById(id).orElse(null);
        if(emp==null){
            return " Not deleted -- Not found ";
        }
        employeeRepository.delete(emp);
        return "Deleted success";
    }

}
