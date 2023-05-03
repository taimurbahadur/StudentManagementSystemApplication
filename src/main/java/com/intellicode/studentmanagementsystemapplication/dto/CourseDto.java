package com.intellicode.studentmanagementsystemapplication.dto;

import lombok.Data;

@Data
public class CourseDto {
    private Long id;
    private String name;
    private DepartmentDto departmentDto;
}
