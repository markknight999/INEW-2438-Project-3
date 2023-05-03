package com.mknight.myjsondb;

import org.springframework.data.jpa.repository.JpaRepository;

// Course DAO
public interface CourseRepository extends JpaRepository<Course, Long> {

    // findAll

}
