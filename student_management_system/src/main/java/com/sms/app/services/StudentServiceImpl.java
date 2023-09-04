package com.sms.app.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.app.entities.Course;
import com.sms.app.entities.Student;
import com.sms.app.entities.StudentAddress;
import com.sms.app.repositories.CourseRepo;
import com.sms.app.repositories.StudentAddressRepo;
import com.sms.app.repositories.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private StudentAddressRepo studentAddressRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<Student> searchStudentsByName(String studentName) {
        return studentRepo.findByNameContainingIgnoreCase(studentName);
    }

    @Override
    public List<Student> searchStudentsByCourse(Long courseId) {
        return studentRepo.findByCourses_Id(courseId);
    }

    @Override
    public Student createStudent(Student s) {
        StudentAddress ad = s.getAddresses().get(0);
        studentAddressRepo.save(ad);

        Student savedStudent = studentRepo.save(s);
        return savedStudent;
    }

    @Override
    public Student updateStudent(Student s, Long studentId) {
        Optional<Student> st = studentRepo.findById(studentId);

        if (st.isPresent()) {
            s.setUniqueStudentCode(studentId);
        }

        return studentRepo.save(s);
    }

    @Override
    public String deleteStudent(Long studentId) {
        Optional<Student> st = studentRepo.findById(studentId);

        if (st.isPresent()) {

            studentRepo.deleteById(studentId);

            return "Student deleted successfully";
        }

        return "Student not found";
    }

    @Override
    public String assignCourseToStudent(Long studentId, Long courseId) {
        Optional<Student> student = studentRepo.findById(studentId);

        if (student.isEmpty()) {
            return "Student not found";
        }

        Student s = student.get();

        Optional<Course> course = courseRepo.findById(courseId);

        if (course.isEmpty()) {
            return "Course not found";
        }

        Course c = course.get();

        s.getCourses().add(c);

        studentRepo.save(s);

        return "Course assigned successfully to the student";
    }

    @Override
    public Student updateStudentProfile(Long studentId, Student updatedStudentDetails) {
        Optional<Student> student = studentRepo.findById(studentId);

        if (student.isEmpty()) {
            throw new RuntimeException("No such a student");
        }

        Student s = student.get();

        s.setDateOfBirth(updatedStudentDetails.getDateOfBirth());
        s.setName(updatedStudentDetails.getName());
        s.setAddresses(updatedStudentDetails.getAddresses());

        return studentRepo.save(s);
    }

    @Override
    public List<String> getAssignedCourseTopics(Long studentId) {
        Optional<Student> student = studentRepo.findById(studentId);

        if (student.isEmpty()) {
            throw new RuntimeException("No such a student");
        }

        Student s = student.get();

        List<Course> assignedCourses = s.getCourses();
        List<String> courseTopics = new ArrayList<>();

        for (Course course : assignedCourses) {
            courseTopics.add(course.getCourseName() + " " + course.getTopics());
        }

        return courseTopics;
    }

    @Override
    public String leaveCourse(Long studentId, Long courseId) {
        Optional<Student> student = studentRepo.findById(studentId);

        if (student.isEmpty()) {
            return "Student not found";
        }

        Student s = student.get();

        Optional<Course> course = courseRepo.findById(courseId);

        if (course.isEmpty()) {
            return "Course not found";
        }

        Course c = course.get();

        s.getCourses().remove(c);
        studentRepo.save(s);

        return "Course assigned to the student removed successfully";
    }

    @Override
    public String studentLogin(String username, LocalDate dateOfBirth) {
        Student s = studentRepo.findByNameAndDateOfBirth(username, dateOfBirth);

        if (s != null) {
            return "Student login successful";
        }

        return "Invalid details";
    }

}
