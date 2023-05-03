package com.mknight.myjsondb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public abstract class StudentImplementation implements StudentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * @param id
     * @return
     */

    @Override
    public Student getById(int id) {

        return jdbcTemplate.queryForObject("SELECT * FROM students, courses WHERE id=?", new BeanPropertyRowMapper<Student>(Student.class), new BeanPropertyRowMapper<Course>(Course.class), id);

    }

}
