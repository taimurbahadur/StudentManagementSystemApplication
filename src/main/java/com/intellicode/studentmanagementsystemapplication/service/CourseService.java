package com.intellicode.studentmanagementsystemapplication.service;

import com.intellicode.studentmanagementsystemapplication.dto.CourseDto;
import com.intellicode.studentmanagementsystemapplication.dto.DepartmentDto;
import com.intellicode.studentmanagementsystemapplication.entity.CourseEntity;
import com.intellicode.studentmanagementsystemapplication.entity.DepartmentEntity;
import com.intellicode.studentmanagementsystemapplication.mapper.CourseMapper;
import com.intellicode.studentmanagementsystemapplication.mapper.DepartmentMapper;
import com.intellicode.studentmanagementsystemapplication.repository.CourseRepository;
import com.intellicode.studentmanagementsystemapplication.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentMapper departmentMapper;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDto> getAllCourse() {

        List<CourseEntity> list = courseRepository.findAllAndIsDeleted();
        List<CourseDto> courseDtos = new ArrayList<>();
        for(CourseEntity courseEntity : list){
            CourseDto courseDto = courseMapper.maptoDto(courseEntity);
            courseDtos.add(courseDto);
        }
        return courseDtos;
    }

    public CourseEntity getCourseById(Long id) {
        return courseRepository.findByIdAndIsDeleted(id);
    }

    public CourseDto saveCourse(CourseDto courseDto) {
        CourseEntity courseEntity = courseMapper.mapToEntity(courseDto);
        DepartmentDto departmentDto;

        if(courseDto.getDepartmentDto() == null){
            throw new RuntimeException("Please enter your department, not my department");
        }
        else {
            DepartmentEntity departmentEntity = departmentRepository.findByIdAndIsDeleted(courseDto.getDepartmentDto().getId());
            departmentDto = departmentMapper.mapToDto(departmentEntity);
            courseEntity.setDepartmentEntity(departmentEntity);
        }
        courseEntity = courseRepository.save(courseEntity);
        courseDto = courseMapper.maptoDto(courseEntity);
        courseDto.setDepartmentDto(departmentDto);

        return courseDto;
    }

    public void deleteCourse(Long id) {
        CourseEntity courseEntity = courseRepository.findById(id).get();
        courseEntity.setDeleted(true);
        courseRepository.save(courseEntity);
    }
}
