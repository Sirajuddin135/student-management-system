package com.sms.app.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.app.entities.Student;
import com.sms.app.services.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Student Management System";
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student s) {
        return studentService.createStudent(s);
    }

    @GetMapping("/students/{studentName}")
    public List<Student> getStudentsByName(@PathVariable String studentName) {
        System.out.println("here");

        return studentService.searchStudentsByName(studentName);
    }

    @GetMapping("/students/courses/{courseId}")
    public List<Student> getStudentsByCourse(@PathVariable Long courseId) {
        return studentService.searchStudentsByCourse(courseId);
    }

    @GetMapping("/students/{studentId}/topics")
    public List<String> getAssignedCourseTopics(@PathVariable Long studentId) {
        return studentService.getAssignedCourseTopics(studentId);
    }

    @PostMapping("/students/{studentId}/courses/{courseId}")
    public String assignCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentService.assignCourseToStudent(studentId, courseId);
    }

    @PostMapping("/students/{studentId}")
    public Student updateStudentProfile(@PathVariable Long studentId, @RequestBody Student student) {
        return studentService.updateStudentProfile(studentId, student);
    }

    @PutMapping("/students/{studentId}")
    public Student updateStudent(@RequestBody Student s, @PathVariable Long studentId) {
        return studentService.updateStudent(s, studentId);
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable Long studentId) {
        return studentService.deleteStudent(studentId);
    }

    @DeleteMapping("/students/{studentId}/courses/{courseId}")
    public String leaveCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentService.leaveCourse(studentId, courseId);
    }

    @PostMapping("/students/login/{username}/{password}")
    public String studentLogin(@PathVariable String username, @PathVariable String password) {
        System.out.println(username);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate date = LocalDate.parse(password, formatter);

        return studentService.studentLogin(username, date);
    }
}
