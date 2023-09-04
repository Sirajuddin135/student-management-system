package com.sms.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.app.entities.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {

    Course findByCourseNameAndDescriptionAndCourseTypeAndDurationAndTopics(String courseName,
            String description, String CourseType, int duration, String topics);
}
