package com.intellicode.studentmanagementsystemapplication.controller;

import com.intellicode.studentmanagementsystemapplication.entity.CourseHasAssessment;
import com.intellicode.studentmanagementsystemapplication.entity.StudentHasCourse;
import com.intellicode.studentmanagementsystemapplication.service.CourseHasAssessmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseassessment")
public class CourseHasAssessmentController {
    private CourseHasAssessmentService courseHasAssessmentService;

    public CourseHasAssessmentController(CourseHasAssessmentService courseHasAssessmentService) {
        this.courseHasAssessmentService = courseHasAssessmentService;
    }

    @GetMapping
    public List<CourseHasAssessment> getAllCourseAssessment(){
        return courseHasAssessmentService.getAllCourseAssessment();
    }

    @GetMapping("/{id}")
    public CourseHasAssessment getCourseAssessmentById(@PathVariable Long id){
        return courseHasAssessmentService.getCourseAssessmentById(id);
    }

    @PostMapping
    public CourseHasAssessment saveCourseAssessment(@RequestBody CourseHasAssessment courseHasAssessment){
        return courseHasAssessmentService.saveCourseAssessment(courseHasAssessment);
    }

    @DeleteMapping("/{id}")
    public void deleteCourseAssessment(@PathVariable Long id){
        courseHasAssessmentService.deleteCourseAssessment(id);
    }
}
