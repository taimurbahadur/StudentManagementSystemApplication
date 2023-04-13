package com.intellicode.studentmanagementsystemapplication.service;

import com.intellicode.studentmanagementsystemapplication.entity.CourseHasAssessment;
import com.intellicode.studentmanagementsystemapplication.entity.StudentHasCourse;
import com.intellicode.studentmanagementsystemapplication.repository.CourseHasAssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseHasAssessmentService {

    @Autowired
    private CourseHasAssessmentRepository courseHasAssessmentRepository;

    public List<CourseHasAssessment> getAllCourseAssessment()
    {
        return courseHasAssessmentRepository.findAllAndIsDeleted();
    }

    public CourseHasAssessment getCourseAssessmentById(Long id){
        return courseHasAssessmentRepository.findByIdAndIsDeleted(id);
    }

    public CourseHasAssessment saveCourseAssessment(CourseHasAssessment courseHasAssessment){
        return courseHasAssessmentRepository.save(courseHasAssessment);
    }

    public void deleteCourseAssessment(Long id){

        CourseHasAssessment courseHasAssessment = courseHasAssessmentRepository.findById(id).get();
        courseHasAssessment.setDeleted(true);
        courseHasAssessmentRepository.save(courseHasAssessment);

    }
}
