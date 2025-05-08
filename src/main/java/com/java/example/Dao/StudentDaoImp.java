package com.java.example.Dao;


import com.java.example.model.Marks;
import com.java.example.model.StudentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImp implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public StudentDetails getStudentById(int id) {
        String sql = "SELECT * FROM student WHERE stu_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new StudentDetails(rs.getInt("stu_id"), rs.getString("stu_name")));
    }

    @Override
    public List<Marks> getMarksByStudentId(int id) {
        String sql = "SELECT * FROM marks WHERE stu_id=?";
        return jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) ->
                new Marks(rs.getString("subject"), rs.getInt("marks")));
    }
}

