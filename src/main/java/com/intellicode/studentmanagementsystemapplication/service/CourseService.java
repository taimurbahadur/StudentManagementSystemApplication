package com.intellicode.studentmanagementsystemapplication.service;

import com.intellicode.studentmanagementsystemapplication.entity.CourseEntity;
import com.intellicode.studentmanagementsystemapplication.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseEntity> getAllCourse(){
        return courseRepository.findAllAndIsDeleted();
    }

    public CourseEntity getCourseById(Long id){
        return courseRepository.findByIdAndIsDeleted(id);
    }

    public CourseEntity saveCourse(CourseEntity courseEntity){
        return courseRepository.save(courseEntity);
    }

    public void deleteCourse(Long id){
        CourseEntity courseEntity = courseRepository.findById(id).get();
        courseEntity.setDeleted(true);
        courseRepository.save(courseEntity);
    }
}
