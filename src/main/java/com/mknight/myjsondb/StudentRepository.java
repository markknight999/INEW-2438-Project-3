package com.mknight.myjsondb;

import com.mknight.myjsondb.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Student DAO
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student getById(int id);

    List<Student> findAll();

}
