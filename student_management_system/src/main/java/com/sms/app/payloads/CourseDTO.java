package com.sms.app.payloads;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private Long id;
    private String courseName;
    private String description;
    private String courseType;
    private int duration;
    private String topics;
    private List<StudentDTO> students;
}
