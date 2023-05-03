package com.intellicode.studentmanagementsystemapplication.controller;

import com.intellicode.studentmanagementsystemapplication.dto.StudentHasCourseDto;
import com.intellicode.studentmanagementsystemapplication.entity.StudentHasCourse;
import com.intellicode.studentmanagementsystemapplication.service.StudentHasCourseService;
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
    public List<StudentHasCourseDto> getAllStudentsCourse() {
        return studentHasCourseService.getAllStudentsCourse();
    }

    @GetMapping("/{id}")
    public StudentHasCourse getStudentCourseById(@PathVariable Long id) {
        return studentHasCourseService.getStudentCourseById(id);
    }

    @PostMapping
    public StudentHasCourseDto saveStudentCourse(@RequestBody StudentHasCourseDto studentHasCourseDto) {
        return studentHasCourseService.saveStudentCourse(studentHasCourseDto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentCourse(@PathVariable Long id) {
        studentHasCourseService.deleteStudentCourse(id);
    }

}
