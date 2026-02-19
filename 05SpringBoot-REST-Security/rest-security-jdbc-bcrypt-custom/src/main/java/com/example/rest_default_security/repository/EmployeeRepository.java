package com.example.rest_default_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest_default_security.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
