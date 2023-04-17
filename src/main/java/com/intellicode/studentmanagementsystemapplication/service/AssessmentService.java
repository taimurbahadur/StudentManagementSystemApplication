package com.intellicode.studentmanagementsystemapplication.service;

import com.intellicode.studentmanagementsystemapplication.entity.AssessmentEntity;
import com.intellicode.studentmanagementsystemapplication.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {
    @Autowired
    private AssessmentRepository assessmentRepository;

    public AssessmentService(AssessmentRepository assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }

    public List<AssessmentEntity> getAllAssessments() {
        return assessmentRepository.findAllAndIsDeleted();
    }

    public AssessmentEntity getAssessmentById(Long id) {
        return assessmentRepository.findByIdAndIsDeleted(id);
    }

    public AssessmentEntity saveAssessment(AssessmentEntity assessmentEntity) {
        return assessmentRepository.save(assessmentEntity);
    }

    public void deleteAssessment(Long id) {
        AssessmentEntity assessmentEntity = assessmentRepository.findById(id).get();
        assessmentEntity.setDeleted(true);
        assessmentRepository.save(assessmentEntity);
    }
}
