package com.intellicode.studentmanagementsystemapplication.mapper;

import com.intellicode.studentmanagementsystemapplication.dto.AssessmentDto;
import com.intellicode.studentmanagementsystemapplication.entity.AssessmentEntity;
import org.springframework.stereotype.Component;

@Component
public class AssessmentMapper {

    // Convert Entity to DTO
    public AssessmentDto mapToDto(AssessmentEntity assessmentEntity) {
        AssessmentDto assessmentDto = new AssessmentDto();
        assessmentDto.setId(assessmentEntity.getId());
        assessmentDto.setName(assessmentEntity.getName());
        assessmentDto.setMarks(assessmentEntity.getMarks());
        return assessmentDto;
    }

    // Convert DTO to Entity
    public AssessmentEntity mapToEntity(AssessmentDto assessmentDto) {
        AssessmentEntity assessmentEntity = new AssessmentEntity();
        assessmentEntity.setId(assessmentDto.getId());
        assessmentEntity.setName(assessmentDto.getName());
        assessmentEntity.setMarks(assessmentDto.getMarks());
        return assessmentEntity;
    }
}
