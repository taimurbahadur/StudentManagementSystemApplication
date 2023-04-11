package com.intellicode.studentmanagementsystemapplication.service;

import com.intellicode.studentmanagementsystemapplication.entity.AddressEntity;
import com.intellicode.studentmanagementsystemapplication.entity.StudentEntity;
import com.intellicode.studentmanagementsystemapplication.mapper.AddressMapper;
import com.intellicode.studentmanagementsystemapplication.mapper.StudentMapper;
import com.intellicode.studentmanagementsystemapplication.repository.StudentRepository;
import com.intellicode.studentmanagementsystemapplication.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private StudentDto studentDto;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


//    public StudentDto createStudent(StudentDto studentDto){
//
//        //Convert DTO into Entity
//        StudentEntity studentEntity = mapToEntity(studentDto);
//        StudentEntity newStudent = studentRepository.save(studentEntity);
//
//        //Convert Entity into DTO
//        StudentDto studentResponse = mapToDTO(newStudent);
//        return studentResponse;
//    }

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

//    public StudentDto saveStudent(StudentDto studentDto){
//        StudentEntity studentEntity = new StudentEntity();
//        StudentMapper studentMapper = new StudentMapper();
//
//        studentEntity = studentMapper.mapToEntity(studentDto);
//
//
//        AddressEntity addressEntity =new AddressEntity();
//        addressEntity.setId(studentDto.get);
//        AddressMapper addressMapper = new AddressMapper();
//
//        addressMapper.mapToEntity(studentEntity);
//
//        studentRepository.save(studentEntity);
//
//        return studentDto;
//    }

    public void deleteStudent(Long id){

        StudentEntity studentEntity = studentRepository.findById(id).get();
        studentEntity.setDeleted(true);
        studentRepository.save(studentEntity);
    }


}
