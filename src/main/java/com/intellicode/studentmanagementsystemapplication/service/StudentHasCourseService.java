package com.intellicode.studentmanagementsystemapplication.service;

import com.intellicode.studentmanagementsystemapplication.dto.CourseDto;
import com.intellicode.studentmanagementsystemapplication.dto.StudentDto;
import com.intellicode.studentmanagementsystemapplication.dto.StudentHasCourseDto;
import com.intellicode.studentmanagementsystemapplication.entity.CourseEntity;
import com.intellicode.studentmanagementsystemapplication.entity.StudentEntity;
import com.intellicode.studentmanagementsystemapplication.entity.StudentHasCourse;
import com.intellicode.studentmanagementsystemapplication.mapper.CourseMapper;
import com.intellicode.studentmanagementsystemapplication.mapper.StudentHasCourseMapper;
import com.intellicode.studentmanagementsystemapplication.mapper.StudentMapper;
import com.intellicode.studentmanagementsystemapplication.repository.CourseRepository;
import com.intellicode.studentmanagementsystemapplication.repository.StudentHasCourseRepository;
import com.intellicode.studentmanagementsystemapplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentHasCourseService {

    @Autowired
    private StudentHasCourseRepository studentHasCourseRepository;

    @Autowired
    private StudentHasCourseMapper studentHasCourseMapper;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;


    public List<StudentHasCourseDto> getAllStudentsCourse() {

        List<StudentHasCourse> list = studentHasCourseRepository.findAllAndIsDeleted();
        List<StudentHasCourseDto> studentHasCourseDtos =  new ArrayList<>();
        for(StudentHasCourse studentHasCourse:list){
            StudentHasCourseDto studentHasCourseDto = studentHasCourseMapper.mapToDto(studentHasCourse);
            studentHasCourseDtos.add(studentHasCourseDto);
        }
        return studentHasCourseDtos;
    }

    public StudentHasCourse getStudentCourseById(Long id) {
        return studentHasCourseRepository.findByIdAndIsDeleted(id);
    }

    public StudentHasCourseDto saveStudentCourse(StudentHasCourseDto studentHasCourseDto) {

        StudentHasCourse studentHasCourse = studentHasCourseMapper.mapToEntity(studentHasCourseDto);
        CourseDto courseDto;
        StudentDto studentDto;

        if(studentHasCourseDto.getCourseDto() == null){
            throw new RuntimeException("Please enter your course name, not my course name");
        }
        else {
            CourseEntity courseEntity = courseRepository.findByIdAndIsDeleted(studentHasCourseDto.getCourseDto().getId());
            courseDto = courseMapper.maptoDto(courseEntity);
            studentHasCourse.setCourseEntity(courseEntity);
        }

        if(studentHasCourseDto.getStudentDto() == null){
            throw new RuntimeException("Please enter student name, not my name");
        }

        else{
            StudentEntity studentEntity = studentRepository.findByIdAndIsDeleted(studentHasCourseDto.getStudentDto().getId());
            studentDto = studentMapper.mapToDto(studentEntity);
            studentHasCourse.setStudentEntity(studentEntity);
        }
        studentHasCourse = studentHasCourseRepository.save(studentHasCourse);
        studentHasCourseDto = studentHasCourseMapper.mapToDto(studentHasCourse);
        studentHasCourseDto.setCourseDto(courseDto);
        studentHasCourseDto.setStudentDto(studentDto);
        return studentHasCourseDto;
    }

    public void deleteStudentCourse(Long id) {

        StudentHasCourse studentHasCourse = studentHasCourseRepository.findById(id).get();
        studentHasCourse.setDeleted(true);
        studentHasCourseRepository.save(studentHasCourse);

    }
}
