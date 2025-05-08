package com.java.example.service;

import com.java.example.Dao.StudentDAO;
import com.java.example.model.Marks;
import com.java.example.model.StudentDetails;
import com.java.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired  // Injects DAO implementation
    private StudentDAO studentDao;

    @Override
    public void showStudentReport(int id) {
        StudentDetails student = studentDao.getStudentById(id);
        List<Marks> marksList = studentDao.getMarksByStudentId(id);

        int total = 0;
        int minMarks = Integer.MAX_VALUE;

        System.out.println("Student ID: " + student.getId());
        System.out.println("Name      : " + student.getName());
        System.out.println(" MarksList:");

        for (Marks m : marksList) {
            System.out.println("  " + m.getSubject() + ": " + m.getMarks());
            total += m.getMarks();
            if (m.getMarks() < minMarks) minMarks = m.getMarks();
        }

        System.out.println("Total Marks: " + total);
        System.out.println("Minimum Marks: " + minMarks);
        System.out.println("Result: " + (minMarks >= 35 ? "Pass" : "Fail"));
    }
}
