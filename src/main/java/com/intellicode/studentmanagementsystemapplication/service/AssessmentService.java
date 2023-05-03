package com.intellicode.studentmanagementsystemapplication.service;

import com.intellicode.studentmanagementsystemapplication.dto.AssessmentDto;
import com.intellicode.studentmanagementsystemapplication.dto.CourseDto;
import com.intellicode.studentmanagementsystemapplication.dto.DepartmentDto;
import com.intellicode.studentmanagementsystemapplication.entity.AssessmentEntity;
import com.intellicode.studentmanagementsystemapplication.entity.CourseEntity;
import com.intellicode.studentmanagementsystemapplication.entity.DepartmentEntity;
import com.intellicode.studentmanagementsystemapplication.mapper.AssessmentMapper;
import com.intellicode.studentmanagementsystemapplication.mapper.CourseMapper;
import com.intellicode.studentmanagementsystemapplication.mapper.DepartmentMapper;
import com.intellicode.studentmanagementsystemapplication.repository.AssessmentRepository;
import com.intellicode.studentmanagementsystemapplication.repository.CourseRepository;
import com.intellicode.studentmanagementsystemapplication.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssessmentService {
    @Autowired
    private AssessmentRepository assessmentRepository;

    @Autowired
    private AssessmentMapper assessmentMapper;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentMapper departmentMapper;

    public AssessmentService(AssessmentRepository assessmentRepository,
                             DepartmentRepository departmentRepository) {
        this.assessmentRepository = assessmentRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<AssessmentDto> getAllAssessments() {

        List<AssessmentEntity> list = assessmentRepository.findAllAndIsDeleted();
        List<AssessmentDto> assessmentDtos = new ArrayList<>();
        for(AssessmentEntity assessmentEntity : list){
            AssessmentDto assessmentDto = assessmentMapper.mapToDto(assessmentEntity);
            assessmentDtos.add(assessmentDto);
        }
        return assessmentDtos;
    }

    public AssessmentEntity getAssessmentById(Long id) {
        return assessmentRepository.findByIdAndIsDeleted(id);
    }

    public AssessmentDto saveAssessment(AssessmentDto assessmentDto) {

        AssessmentEntity assessmentEntity = assessmentMapper.mapToEntity(assessmentDto);
        CourseDto courseDto;

        if(assessmentDto.getCourseDto() == null){
            throw new RuntimeException("Please enter your course name, not my course name");
        }
        else {
            CourseEntity courseEntity = courseRepository.findByIdAndIsDeleted(assessmentDto.getCourseDto().getId());
            courseDto = courseMapper.maptoDto(courseEntity);
            assessmentEntity.setCourseEntity(courseEntity);
            DepartmentEntity departmentEntity = departmentRepository.findByIdAndIsDeleted(courseEntity.getDepartmentEntity().getId());
            DepartmentDto departmentDto = departmentMapper.mapToDto(departmentEntity);
            courseEntity.setDepartmentEntity(departmentEntity);
            courseDto.setDepartmentDto(departmentDto);

        }
        assessmentEntity = assessmentRepository.save(assessmentEntity);
        assessmentDto = assessmentMapper.mapToDto(assessmentEntity);
        assessmentDto.setCourseDto(courseDto);


        return assessmentDto;
    }

    public void deleteAssessment(Long id) {
        AssessmentEntity assessmentEntity = assessmentRepository.findById(id).get();
        assessmentEntity.setDeleted(true);
        assessmentRepository.save(assessmentEntity);
    }
}
