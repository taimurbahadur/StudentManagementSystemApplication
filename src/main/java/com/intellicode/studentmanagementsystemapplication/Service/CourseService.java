package com.intellicode.studentmanagementsystemapplication.Service;

import com.intellicode.studentmanagementsystemapplication.Entity.CourseEntity;
import com.intellicode.studentmanagementsystemapplication.Repository.CourseRepository;
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
        return courseRepository.findAll();
    }

    public CourseEntity getCourseById(Long id){
        return courseRepository.findById(id).orElse(null);
    }

    public CourseEntity saveCourse(CourseEntity courseEntity){
        return courseRepository.save(courseEntity);
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }
}
