package com.intellicode.studentmanagementsystemapplication.dto;

import lombok.Data;

@Data
public class StudentHasCourseDto {
    private Long id;
    private String grade;
    private CourseDto courseDto;
    private StudentDto studentDto;
}
