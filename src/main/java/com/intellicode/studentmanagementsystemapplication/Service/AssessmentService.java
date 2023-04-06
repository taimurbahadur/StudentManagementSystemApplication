package com.intellicode.studentmanagementsystemapplication.Service;

import com.intellicode.studentmanagementsystemapplication.Entity.AssessmentEntity;
import com.intellicode.studentmanagementsystemapplication.Repository.AssessmentRepository;
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

    public List<AssessmentEntity> getAllAssessments(){
        return assessmentRepository.findAll();
    }

    public AssessmentEntity getAssessmentById(Long id){
        return assessmentRepository.findById(id).orElse(null);
    }

    public AssessmentEntity saveAssessment(AssessmentEntity assessmentEntity){
        return assessmentRepository.save(assessmentEntity);
    }

    public void deleteAssessment(Long id){
        assessmentRepository.deleteById(id);
    }
}
