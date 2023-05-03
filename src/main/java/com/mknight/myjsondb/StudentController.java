package com.mknight.myjsondb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;
/*
    @GetMapping(value = "/student/{id}")
    public Student getStudentById(@PathVariable int id) {

        return studentRepository.getById(id);

    }
/*
    @GetMapping("/student")
    public List<Student> getStudents() {

        return studentRepository.findAll();

    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(@RequestParam(name = "id", required = false) Integer id) {
        List<Student> students = new ArrayList<>();
        if (id != null) {
            Optional<Student> student = studentRepository.findById(id);
            if (student.isPresent()) {
                students.add(student.get());
                return ResponseEntity.ok().body(students);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            students = studentRepository.findAll();
            return ResponseEntity.ok().body(students);
        }
    }

    @GetMapping(path = "/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable String id) {
        int studentId = Integer.parseInt(id);

        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if (optionalStudent.isPresent()) {
            return ResponseEntity.ok(optionalStudent.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/students/all")
    public List<Student> getAllStudents() {

        return studentRepository.findAll();

    }
*/
    @GetMapping("/students/all")
    public ResponseEntity<List<Student>> getAllStudents(@RequestParam(name = "id", required = false) Integer id) {
        List<Student> students = new ArrayList<>();
        if (id != null) {
            Optional<Student> student = studentRepository.findById(id);
            if (student.isPresent()) {
                students.add(student.get());
                return ResponseEntity.ok().body(students);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            students = studentRepository.findAll();
            return ResponseEntity.ok().body(students);
        }
    }

}


