package com.mknight.myjsondb;

import com.mknight.myjsondb.Student;
import java.util.List;

public interface StudentDAO {

    int save(Student students);

    int add(Student students);

    int update(Student students, int id);

    int delete(int id);

    List<Student> getAll();

    Student getById(int id);

}
