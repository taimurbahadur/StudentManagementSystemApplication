package com.intellicode.studentmanagementsystemapplication.controller;

import com.intellicode.studentmanagementsystemapplication.dto.AssessmentDto;
import com.intellicode.studentmanagementsystemapplication.entity.AssessmentEntity;
import com.intellicode.studentmanagementsystemapplication.service.AssessmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assessment")
public class AssessmentController {
    private final AssessmentService assessmentService;

    public AssessmentController(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }


    @GetMapping
    public List<AssessmentDto> getAllAssessments() {
        return assessmentService.getAllAssessments();
    }

    @GetMapping("/{id}")
    public AssessmentEntity getAssessmentById(@PathVariable Long id) {
        return assessmentService.getAssessmentById(id);
    }

    @PostMapping
    public AssessmentDto saveAssessment(@RequestBody AssessmentDto assessmentDto) {
        return assessmentService.saveAssessment(assessmentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAssessment(@PathVariable Long id) {
        assessmentService.deleteAssessment(id);
    }

}
