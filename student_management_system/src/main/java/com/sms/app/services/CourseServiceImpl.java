package com.sms.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.app.entities.Course;
import com.sms.app.repositories.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<Course> getCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course createCourse(Course c) {
        return courseRepo.save(c);
    }

    @Override
    public Course updateCourse(Course c, Long courseId) {
        Optional<Course> cs = courseRepo.findById(courseId);

        if (cs.isPresent()) {
            c.setId(courseId);
        }

        return courseRepo.save(c);
    }

    @Override
    public String deleteCourse(Long courseId) {
        courseRepo.deleteById(courseId);

        return "Course deleted successfully";
    }

}
