package com.mknight.myjsondb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name")
    private String first_name;
    @Column(name="email")
    private String email;
    @Column(name = "gender")
    private String gender;
    //----------------------------
    @Column(name = "courseNo")
    private String courseNo;
    @Column(name = "grade")
    private String grade;
    @Column(name = "creditHours")
    private int creditHours;
    //----------------------------

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Course> course = new ArrayList<>();

    public Student() {

        this.course = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Course> getCourse() {
        return course;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setCourse(List<Course> course) {

        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", course=" + course +
                '}';
    }

}
