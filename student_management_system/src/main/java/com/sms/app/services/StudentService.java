package com.sms.app.services;

import java.time.LocalDate;
import java.util.List;

import com.sms.app.entities.Student;

public interface StudentService {
    List<Student> searchStudentsByName(String name);

    List<Student> searchStudentsByCourse(Long courseId);

    Student createStudent(Student s);

    Student updateStudent(Student s, Long studentId);

    String deleteStudent(Long studentId);

    String assignCourseToStudent(Long studentId, Long courseId);

    Student updateStudentProfile(Long studentId, Student updatedStudentDetails);

    List<String> getAssignedCourseTopics(Long studentId);

    String leaveCourse(Long studentId, Long courseId);

    String studentLogin(String username, LocalDate dateOfBirth);
}
