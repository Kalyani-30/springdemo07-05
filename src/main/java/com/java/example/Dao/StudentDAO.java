package com.java.example.Dao;

import com.java.example.model.Marks;
import com.java.example.model.StudentDetails;

import java.util.List;

public interface StudentDAO {

    StudentDetails getStudentById(int id);
    List<Marks> getMarksByStudentId(int id);
}


