package com.mknight.myjsondb;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class MyJsonDbApplication {

    public static void main(String[] args) {

        SpringApplication.run(MyJsonDbApplication.class, args);

    }

    @Bean
    public CommandLineRunner demo(StudentRepository studentRepository, CourseRepository courseRepository) {
        return (args) -> {

            String url = "https://hccs-advancejava.s3.amazonaws.com/student_course.json";
            RestTemplate restTemplate = new RestTemplate();
            String jsonString = restTemplate.getForObject(url, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            //List<Student> students = objectMapper.readValue(jsonString, new TypeReference<List<Student>>(){});
            List<Student> students = objectMapper.readValue(jsonString, TypeFactory.defaultInstance().constructCollectionType(List.class, Student.class));
            //List<Course> courses = objectMapper.readValue(jsonString, new TypeReference<List<Course>>(){});
            //List<Course> courses = objectMapper.readValue(jsonString, TypeFactory.defaultInstance().constructCollectionType(List.class, Course.class));

            // ----------- manually create List of blank courses -------------
            List<Course> courses = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                Course cou = new Course();
                cou.setId(0 + i);
                cou.setCourseNo("NA");
                cou.setGrade("NA");
                cou.setCreditHours(0);
                courses.add(cou);
            }

            // -----------manually map student values to course values -------
            courses.get(0).setId(1);
            courses.get(0).setCourseNo("NA");
            courses.get(0).setGrade("NA");
            courses.get(0).setCreditHours(0);

            courses.get(1).setId(2);
            courses.get(1).setCourseNo("NA");
            courses.get(1).setGrade("NA");
            courses.get(1).setCreditHours(0);

            courses.get(2).setId(3);
            courses.get(2).setCourseNo("CS");
            courses.get(2).setGrade("B");
            courses.get(2).setCreditHours(4);

            courses.get(3).setId(4);
            courses.get(3).setCourseNo("CS12");
            courses.get(3).setGrade("A");
            courses.get(3).setCreditHours(4);

            courses.get(4).setId(5);
            courses.get(4).setCourseNo("BS");
            courses.get(4).setGrade("B");
            courses.get(4).setCreditHours(3);

            courses.get(5).setId(6);
            courses.get(5).setCourseNo("Hist");
            courses.get(5).setGrade("A");
            courses.get(5).setCreditHours(3);

            courses.get(6).setId(7);
            courses.get(6).setCourseNo("ENG");
            courses.get(6).setGrade("A");
            courses.get(6).setCreditHours(4);

            courses.get(7).setId(8);
            courses.get(7).setCourseNo("CS12");
            courses.get(7).setGrade("A");
            courses.get(7).setCreditHours(4);
            // -----------manually map student values to course values -------

        };

    }

}
