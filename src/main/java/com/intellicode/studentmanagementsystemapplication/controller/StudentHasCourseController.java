package com.intellicode.studentmanagementsystemapplication.controller;

import com.intellicode.studentmanagementsystemapplication.entity.StudentEntity;
import com.intellicode.studentmanagementsystemapplication.entity.StudentHasCourse;
import com.intellicode.studentmanagementsystemapplication.service.StudentHasCourseService;
import com.intellicode.studentmanagementsystemapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentcourse")
public class StudentHasCourseController {
    @Autowired
    private StudentHasCourseService studentHasCourseService;

    public StudentHasCourseController(StudentHasCourseService studentHasCourseService) {
        this.studentHasCourseService = studentHasCourseService;
    }

    @GetMapping
    public List<StudentHasCourse> getAllStudentsCourse(){
        return studentHasCourseService.getAllStudentsCourse();
    }

    @GetMapping("/{id}")
    public StudentHasCourse getStudentCourseById(@PathVariable Long id){
        return studentHasCourseService.getStudentCourseById(id);
    }

    @PostMapping
    public StudentHasCourse saveStudentCourse(@RequestBody StudentHasCourse studentHasCourse){
        return studentHasCourseService.saveStudentCourse(studentHasCourse);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentCourse(@PathVariable Long id){
        studentHasCourseService.deleteStudentCourse(id);
    }

}
