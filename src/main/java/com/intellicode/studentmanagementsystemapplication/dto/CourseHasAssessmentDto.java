package com.intellicode.studentmanagementsystemapplication.dto;

import lombok.Data;

@Data
public class CourseHasAssessmentDto {
    private Long id;
    private int marks;
    private AssessmentDto assessmentDto;
    private StudentHasCourseDto studentHasCourseDto;
}
