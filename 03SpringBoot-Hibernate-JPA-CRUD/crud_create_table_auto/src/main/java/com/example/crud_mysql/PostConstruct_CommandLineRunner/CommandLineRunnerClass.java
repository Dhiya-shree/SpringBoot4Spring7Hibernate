package com.example.crud_mysql.PostConstruct_CommandLineRunner;

import java.util.List;
import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.crud_mysql.dao.StudentDAO;
import com.example.crud_mysql.entity.Student;

@Component
public class CommandLineRunnerClass {

    private Scanner scan;

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        scan = new Scanner(System.in);
        return runner -> {
            createStudent(studentDAO);
            readStudent(studentDAO);
            findAll(studentDAO);
            findByLastName(studentDAO);
            updateStudent(studentDAO);
            delete(studentDAO);
            deleteAll(studentDAO);

        };
    }

    private void readStudent(StudentDAO studentDAO) {

        System.out.println(" Find the student of ID: ");
        int idFind = scan.nextInt();
        System.out.println("Student is " + studentDAO.findById(idFind));
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println(" Count ");
        int count = scan.nextInt();
        while (count-- > 0) {
            // System.out.println(" Name :");
            // String name = "ABCD EFGH";
            // try {
            //     name = scan.next();
            // } catch (Exception e) {
            //     name = "ABCD EFGH";
            // }

            // String names[] = {name.substring(0,name.indexOf(" ")),
            //                name.substring(name.indexOf(" ")+1,-1)};
             studentDAO.save(new Student("ABCD", "EFGH"));
        }

    }

    private void findAll(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private void findByLastName(StudentDAO studentDAO) {
        String lastName = "EFGH";
        try {
            System.out.println(" Put last name ");
            lastName = scan.next();
        } catch (Exception e) {
            lastName = "EFGH";
        }
        List<Student> students = studentDAO.findByLastName(lastName);
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private void updateStudent(StudentDAO studentDAO) {
        Student student = studentDAO.findById(1);
        System.out.println(" cURRENT student ----------- ");
        System.out.println(student);
        student.setFirstName("SSSSS");
        student.setLastName("sss");
        studentDAO.update(student);
        System.out.println(" Updated ------- ");
        System.out.println(student);

    }

    private void delete(StudentDAO studentDAO) {
        int id = 1;
        try {
            id = scan.nextInt();
        } catch (Exception e) {
            id = 1;
        }
        studentDAO.delete(id);
        System.out.println(" Deleted user ....... " + id);
    }

    private void deleteAll(StudentDAO studentDAO) {
        System.out.println(" Deleting all ............");
        int nums = studentDAO.deleteAll();
        System.out.println(" Deleted count = " + nums);
    }

}
