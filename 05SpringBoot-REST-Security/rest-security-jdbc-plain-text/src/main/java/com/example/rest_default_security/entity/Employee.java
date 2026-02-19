package com.example.rest_default_security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private int id;

 private String username;
 private String firstName;
 private String lastName;
 private String mail;

 public Employee(){

 }
 
 public Employee(String username, String firstName, String lastName, String mail) {
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.mail = mail;
}
 public String getUsername() {
    return username;
 }
 public void setUsername(String username) {
    this.username = username;
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

 public int getId() {
    return id;
 }

 public void setId(int id) {
    this.id = id;
 }

 
 

}
