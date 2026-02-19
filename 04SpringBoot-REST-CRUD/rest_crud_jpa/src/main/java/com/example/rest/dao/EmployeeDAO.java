package com.example.rest.dao;

import java.util.List;

import com.example.rest.entity.Employee;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
