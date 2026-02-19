package com.example.rest.entity;

public class EmployeeData {
      
    private String fname;
    private String lname;
    private String mail;
    private int dept;
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public int getDept() {
        return dept;
    }
    public void setDept(int dept) {
        this.dept = dept;
    }

    
}
