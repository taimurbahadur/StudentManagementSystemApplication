package com.intellicode.studentmanagementsystemapplication.Service;

import com.intellicode.studentmanagementsystemapplication.Entity.StudentEntity;
import com.intellicode.studentmanagementsystemapplication.Repository.StudentRepository;
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
        return studentRepository.findAll();
    }

    public StudentEntity getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public StudentEntity saveStudent(StudentEntity studentEntity){
        return studentRepository.save(studentEntity);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }


}
