package com.intellicode.studentmanagementsystemapplication.service;

import com.intellicode.studentmanagementsystemapplication.entity.StudentEntity;
import com.intellicode.studentmanagementsystemapplication.entity.StudentHasCourse;
import com.intellicode.studentmanagementsystemapplication.repository.StudentHasCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentHasCourseService {

    @Autowired
    private StudentHasCourseRepository studentHasCourseRepository;

    public List<StudentHasCourse> getAllStudentsCourse()
    {
        return studentHasCourseRepository.findAllAndIsDeleted();
    }

    public StudentHasCourse getStudentCourseById(Long id){
        return studentHasCourseRepository.findByIdAndIsDeleted(id);
    }

    public StudentHasCourse saveStudentCourse(StudentHasCourse studentHasCourse){
        return studentHasCourseRepository.save(studentHasCourse);
    }

    public void deleteStudentCourse(Long id){

    StudentHasCourse studentHasCourse = studentHasCourseRepository.findById(id).get();
    studentHasCourse.setDeleted(true);
    studentHasCourseRepository.save(studentHasCourse);

    }
}
