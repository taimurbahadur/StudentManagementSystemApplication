package com.intellicode.studentmanagementsystemapplication.service;

import com.intellicode.studentmanagementsystemapplication.dto.*;
import com.intellicode.studentmanagementsystemapplication.entity.AssessmentEntity;
import com.intellicode.studentmanagementsystemapplication.entity.CourseHasAssessment;
import com.intellicode.studentmanagementsystemapplication.entity.StudentHasCourse;
import com.intellicode.studentmanagementsystemapplication.mapper.AssessmentMapper;
import com.intellicode.studentmanagementsystemapplication.mapper.CourseHasAssessmentMapper;
import com.intellicode.studentmanagementsystemapplication.mapper.StudentHasCourseMapper;
import com.intellicode.studentmanagementsystemapplication.repository.AssessmentRepository;
import com.intellicode.studentmanagementsystemapplication.repository.CourseHasAssessmentRepository;
import com.intellicode.studentmanagementsystemapplication.repository.StudentHasCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseHasAssessmentService {

    @Autowired
    private CourseHasAssessmentRepository courseHasAssessmentRepository;

    @Autowired
    private CourseHasAssessmentMapper courseHasAssessmentMapper;

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Autowired
    private AssessmentMapper assessmentMapper;

    @Autowired
    private StudentHasCourseRepository studentHasCourseRepository;

    @Autowired
    private StudentHasCourseMapper studentHasCourseMapper;

    public CourseHasAssessmentService(CourseHasAssessmentRepository courseHasAssessmentRepository, CourseHasAssessmentMapper courseHasAssessmentMapper, AssessmentRepository assessmentRepository, AssessmentMapper assessmentMapper, StudentHasCourseRepository studentHasCourseRepository, StudentHasCourseMapper studentHasCourseMapper) {
        this.courseHasAssessmentRepository = courseHasAssessmentRepository;
        this.courseHasAssessmentMapper = courseHasAssessmentMapper;
        this.assessmentRepository = assessmentRepository;
        this.assessmentMapper = assessmentMapper;
        this.studentHasCourseRepository = studentHasCourseRepository;
        this.studentHasCourseMapper = studentHasCourseMapper;
    }

    public List<CourseHasAssessmentDto> getAllCourseAssessment() {
        List<CourseHasAssessment> list = courseHasAssessmentRepository.findAllAndIsDeleted();
        List<CourseHasAssessmentDto> courseHasAssessmentDtos = new ArrayList<>();

        for (CourseHasAssessment courseHasAssessment : list) {
            CourseHasAssessmentDto courseHasAssessmentDto = courseHasAssessmentMapper.mapToDto(courseHasAssessment);
            courseHasAssessmentDtos.add(courseHasAssessmentDto);
        }
        return courseHasAssessmentDtos;
    }

    public CourseHasAssessment getCourseAssessmentById(Long id) {
        return courseHasAssessmentRepository.findByIdAndIsDeleted(id);
    }

    public CourseHasAssessmentDto saveCourseAssessment(CourseHasAssessmentDto courseHasAssessmentDto) {

        CourseHasAssessment courseHasAssessment = courseHasAssessmentMapper.mapToEntity(courseHasAssessmentDto);
        AssessmentDto assessmentDto;
        StudentHasCourseDto studentHasCourseDto;

        if (courseHasAssessmentDto.getAssessmentDto() == null) {
            throw new RuntimeException("Please enter your assessment name, not my assessment name");
        } else {
            AssessmentEntity assessmentEntity = assessmentRepository.findByIdAndIsDeleted(courseHasAssessmentDto.getAssessmentDto().getId());
            assessmentDto = assessmentMapper.mapToDto(assessmentEntity);
            courseHasAssessment.setAssessmentEntity(assessmentEntity);
        }

        if (courseHasAssessmentDto.getStudentHasCourseDto() == null) {
            throw new RuntimeException("Please enter your course assessment name, not my course assessment name");
        } else {
            StudentHasCourse studentHasCourse = studentHasCourseRepository.findByIdAndIsDeleted(courseHasAssessmentDto.getStudentHasCourseDto().getId());
            studentHasCourseDto = studentHasCourseMapper.mapToDto(studentHasCourse);
            courseHasAssessment.setStudentHasCourse(studentHasCourse);
        }
        courseHasAssessment = courseHasAssessmentRepository.save(courseHasAssessment);
        courseHasAssessmentDto = courseHasAssessmentMapper.mapToDto(courseHasAssessment);
        courseHasAssessmentDto.setAssessmentDto(assessmentDto);
        courseHasAssessmentDto.setStudentHasCourseDto(studentHasCourseDto);
        return courseHasAssessmentDto;
    }

    public void deleteCourseAssessment(Long id) {

        CourseHasAssessment courseHasAssessment = courseHasAssessmentRepository.findById(id).get();
        courseHasAssessment.setDeleted(true);
        courseHasAssessmentRepository.save(courseHasAssessment);

    }
}
