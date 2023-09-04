package com.sms.app.services;

import java.util.List;

import com.sms.app.entities.Course;

public interface CourseService {
    List<Course> getCourses();

    Course createCourse(Course c);

    Course updateCourse(Course c, Long courseId);

    String deleteCourse(Long courseId);
}
