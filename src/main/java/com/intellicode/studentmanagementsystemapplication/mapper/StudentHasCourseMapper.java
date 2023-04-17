package com.intellicode.studentmanagementsystemapplication.mapper;

import com.intellicode.studentmanagementsystemapplication.dto.StudentDto;
import com.intellicode.studentmanagementsystemapplication.dto.StudentHasCourseDto;
import com.intellicode.studentmanagementsystemapplication.entity.StudentHasCourse;

public class StudentHasCourseMapper {

    // Convert Entity to DTO
    public StudentHasCourseDto mapToDto(StudentHasCourse studentHasCourse) {
        StudentHasCourseDto studentHasCourseDto = new StudentHasCourseDto();
        studentHasCourseDto.setId(studentHasCourse.getId());
        studentHasCourseDto.setGrade(studentHasCourse.getGrade());
        return studentHasCourseDto;
    }

    // Convert DTO to Entity
    public StudentHasCourse mapToEntity(StudentHasCourseDto studentHasCourseDto) {
        StudentHasCourse studentHasCourse = new StudentHasCourse();
        studentHasCourse.setId(studentHasCourseDto.getId());
        studentHasCourse.setGrade(studentHasCourseDto.getGrade());
        return studentHasCourse;
    }
}
