package com.example.crud_mysql.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud_mysql.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager manager;

    public StudentDAOImpl(EntityManager en){
        this.manager=en;
    }

    @Override
    @Transactional
    public void save(Student student) {
       manager.persist(student);   
    }

    @Override
    public Student findById(Integer id) {
       return manager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query=manager.createQuery("FROM Student",Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query=manager.createQuery
                  ("FROM Student where lastName =:theData ", Student.class);
        query.setParameter("theData", lastName);
        return query.getResultList();
                }  

    @Override
    @Transactional
    public void update(Student student) {
        manager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student=manager.find(Student.class,id);
        manager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
       int numDeleted=manager.createQuery("DELETE FROM Student").executeUpdate();
       return numDeleted;
    }
  
}
