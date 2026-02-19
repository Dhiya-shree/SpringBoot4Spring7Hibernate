package com.example.rest.rest;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.entity.Employee;
import com.example.rest.entity.EmployeeData;
import com.example.rest.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/emp")
public class EmployeeRestController {

    @Autowired
    private EmployeeRepository employeeRepository;

    private ObjectMapper objectMapper;

    public EmployeeRestController(ObjectMapper objectMapper){
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm"));
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return employeeRepository.findById(id).get();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody EmployeeData employeedata){
        Employee employee=new Employee(employeedata);
        employee=employeeRepository.save(employee);
        return employee;
    }

    @PutMapping("/employees")
     public Employee addEmployee(@RequestBody Employee employee){
        Employee  updatedEmployee=employeeRepository.save(employee);
        return updatedEmployee;
    }

    @PatchMapping("/employees/{id}")
    public Employee patchEmployee(@PathVariable Integer id, @RequestBody Map<String,Object> patchPayLoad){
        Employee emp=employeeRepository.findById(id).get();
        if(emp==null){
            throw new RuntimeException(" ID not found "+id);
        }
        if(patchPayLoad.containsKey("id")){
            throw new RuntimeException(" ID not Allowed "+id);
        }

        Employee patcheEmployee=apply(patchPayLoad,emp);
        Employee employee=employeeRepository.save(patcheEmployee);
        return employee;
    }

    private Employee apply(Map<String,Object> patchPayLoad, Employee emp) {
       
        ObjectNode employeeNode=objectMapper.convertValue(emp,ObjectNode.class);
        ObjectNode patchNode=objectMapper.convertValue(patchPayLoad,ObjectNode.class);
        employeeNode.setAll(patchNode);
        return objectMapper.convertValue(employeeNode,Employee.class);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        employeeRepository.deleteById(id);
         return "Deletion process completed";
    }


}
