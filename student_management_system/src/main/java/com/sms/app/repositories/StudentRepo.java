package com.sms.app.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.app.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

    List<Student> findByNameContainingIgnoreCase(String studentName);

    List<Student> findByCourses_Id(Long courseId);

    Student findByNameAndDateOfBirth(String username, LocalDate dateOfBirth);
}
