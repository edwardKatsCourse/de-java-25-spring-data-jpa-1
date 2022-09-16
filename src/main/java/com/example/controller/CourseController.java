package com.example.controller;

import com.example.entity.Course;
import com.example.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourseController {


    private final CourseRepository courseRepository;


    @PostMapping("/courses")
    public Course saveCourse(@RequestParam("course") String course) {
        var dbCourse = Course.builder().courseName(course).build();

        return courseRepository.save(dbCourse);
//        return dbCourse;
    }


    @GetMapping("/courses")
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

}
