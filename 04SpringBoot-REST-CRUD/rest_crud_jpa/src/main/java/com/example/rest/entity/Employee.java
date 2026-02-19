package com.example.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue()
    private int id;
    private String firstName;
    private String lastName;
    private String mail;
    private DEPARTMENT dept;

   
    public Employee() {
        this.firstName = "FirstName";
        this.lastName = "LastName";
        this.mail=firstName+"."+lastName+"@gmail.com";
        this.dept=DEPARTMENT.getDept();
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail=firstName+"."+lastName+"@gmail.com";
        this.dept=DEPARTMENT.getDept();
    }

    public Employee(EmployeeData employeeData){
        this.firstName=employeeData.getFname();
        this.lastName=employeeData.getLname();
        this.mail=employeeData.getMail();
        this.dept=DEPARTMENT.values()[employeeData.getDept()%DEPARTMENT.values().length];

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public DEPARTMENT getDept() {
        return dept;
    }
    public void setDept(DEPARTMENT dept) {
        this.dept = dept;
    }


    
}
