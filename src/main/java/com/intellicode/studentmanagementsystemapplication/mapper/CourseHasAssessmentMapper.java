package com.intellicode.studentmanagementsystemapplication.mapper;

import com.intellicode.studentmanagementsystemapplication.dto.CourseHasAssessmentDto;
import com.intellicode.studentmanagementsystemapplication.dto.StudentHasCourseDto;
import com.intellicode.studentmanagementsystemapplication.entity.CourseHasAssessment;
import com.intellicode.studentmanagementsystemapplication.entity.StudentHasCourse;
import org.springframework.stereotype.Component;

@Component
public class CourseHasAssessmentMapper {

    // Convert Entity to DTO
    public CourseHasAssessmentDto mapToDto(CourseHasAssessment courseHasAssessment) {
        CourseHasAssessmentDto courseHasAssessmentDto = new CourseHasAssessmentDto();
        courseHasAssessmentDto.setId(courseHasAssessment.getId());
        courseHasAssessmentDto.setMarks(courseHasAssessment.getMarks());
        return courseHasAssessmentDto;
    }

    // Convert DTO to Entity

    public CourseHasAssessment mapToEntity(CourseHasAssessmentDto courseHasAssessmentDto) {
        CourseHasAssessment courseHasAssessment = new CourseHasAssessment();
        courseHasAssessment.setId(courseHasAssessmentDto.getId());
        courseHasAssessment.setMarks(courseHasAssessmentDto.getMarks());
        return courseHasAssessment;
    }
}
