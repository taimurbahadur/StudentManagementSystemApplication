package com.intellicode.studentmanagementsystemapplication.dto;

import lombok.Data;

@Data
public class AssessmentDto {
    private Long id;
    private String name;
    private Double marks;
    private CourseDto courseDto;
}
