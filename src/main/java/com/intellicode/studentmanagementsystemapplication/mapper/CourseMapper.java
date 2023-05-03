package com.intellicode.studentmanagementsystemapplication.mapper;

import com.intellicode.studentmanagementsystemapplication.dto.CourseDto;
import com.intellicode.studentmanagementsystemapplication.entity.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    // Convert Entity to DTO
    public CourseDto maptoDto(CourseEntity courseEntity) {
        CourseDto courseDto = new CourseDto();
        courseDto.setId(courseEntity.getId());
        courseDto.setName(courseEntity.getName());
        return courseDto;
    }

    // Convert DTO to Entity
    public CourseEntity mapToEntity(CourseDto courseDto) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(courseDto.getId());
        courseEntity.setName(courseDto.getName());
        return courseEntity;
    }
}
