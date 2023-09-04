package com.sms.app.payloads;

import java.time.LocalDate;
import java.util.List;

import com.sms.app.entities.StudentAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long uniqueStudentCode;
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private StudentAddress address;
    private List<String> courses;
}
