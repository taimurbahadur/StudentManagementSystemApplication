package com.intellicode.studentmanagementsystemapplication.service;

import com.intellicode.studentmanagementsystemapplication.entity.StudentEntity;
import com.intellicode.studentmanagementsystemapplication.repository.CourseRepository;
import com.intellicode.studentmanagementsystemapplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<StudentEntity> getAllStudents()
    {
        return studentRepository.findAllAndIsDeleted();
    }

    public StudentEntity getStudentById(Long id){
        return studentRepository.findByIdAndIsDeleted(id);
    }

    public StudentEntity saveStudent(StudentEntity studentEntity){
        return studentRepository.save(studentEntity);
    }

    public void deleteStudent(Long id){

        StudentEntity studentEntity = studentRepository.findById(id).get();
        studentEntity.setDeleted(true);
        studentRepository.save(studentEntity);
    }

}
