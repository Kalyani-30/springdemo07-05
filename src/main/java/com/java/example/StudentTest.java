package com.java.example;

import com.java.example.service.StudentService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService service = context.getBean(StudentService.class);

        service.showStudentReport(2);  // Change ID as needed
    }
}
