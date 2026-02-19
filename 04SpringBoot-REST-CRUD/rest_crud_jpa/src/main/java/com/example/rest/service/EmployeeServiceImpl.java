package com.example.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rest.dao.EmployeeDAO;
import com.example.rest.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
          return employeeDAO.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
         return employeeDAO.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }

}
