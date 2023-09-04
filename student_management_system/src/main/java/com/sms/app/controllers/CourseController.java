package com.sms.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.app.entities.Course;
import com.sms.app.services.CourseService;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @PostMapping("/course")
    public Course createCourse(@RequestBody Course c) {
        return courseService.createCourse(c);
    }

    @PutMapping("/courses/{courseId}")
    public Course updateCourse(@RequestBody Course c, @PathVariable Long courseId) {

        return courseService.updateCourse(c, courseId);
    }

    @DeleteMapping("/course/{courseId}")
    public String deleteCourse(@RequestBody Course c, @PathVariable Long courseId) {
        return courseService.deleteCourse(courseId);
    }

}
