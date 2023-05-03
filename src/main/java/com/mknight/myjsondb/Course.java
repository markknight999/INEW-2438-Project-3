package com.mknight.myjsondb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "courseNo")
    private String courseNo;

    @Column(name = "grade")
    private String grade;

    @Column(name = "creditHours")
    private int creditHours;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "student_id")
    private Student student;

    public Course() {

    }

    public Course(String courseNo, String grade, int creditHours) {

        this.courseNo = courseNo;
        this.grade = grade;
        this.creditHours = creditHours;

    }

    public Course(int id, String courseNo, String grade, int creditHours) {

        this.id = id;
        this.courseNo = courseNo;
        this.grade = grade;
        this.creditHours = creditHours;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseNo='" + courseNo + '\'' +
                ", grade='" + grade + '\'' +
                ", creditHours='" + creditHours + '\'' +
                //", student=" + student +
                '}';
    }

}
