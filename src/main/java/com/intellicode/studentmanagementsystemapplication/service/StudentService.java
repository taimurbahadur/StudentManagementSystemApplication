package com.intellicode.studentmanagementsystemapplication.service;

import com.intellicode.studentmanagementsystemapplication.dto.AddressDto;
import com.intellicode.studentmanagementsystemapplication.dto.DepartmentDto;
import com.intellicode.studentmanagementsystemapplication.dto.StudentDto;
import com.intellicode.studentmanagementsystemapplication.entity.AddressEntity;
import com.intellicode.studentmanagementsystemapplication.entity.DepartmentEntity;
import com.intellicode.studentmanagementsystemapplication.entity.StudentEntity;
import com.intellicode.studentmanagementsystemapplication.mapper.AddressMapper;
import com.intellicode.studentmanagementsystemapplication.mapper.DepartmentMapper;
import com.intellicode.studentmanagementsystemapplication.mapper.StudentMapper;
import com.intellicode.studentmanagementsystemapplication.repository.AddressRepository;
import com.intellicode.studentmanagementsystemapplication.repository.DepartmentRepository;
import com.intellicode.studentmanagementsystemapplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private AddressMapper addressMapper;
    private final AddressRepository addressRepository;
    @Autowired
    private DepartmentMapper departmentMapper;

    public StudentService(StudentRepository studentRepository,
                          DepartmentRepository departmentRepository,
                          AddressRepository addressRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.addressRepository = addressRepository;
    }


    public List<StudentDto> getAllStudents() {
        List<StudentEntity> list = studentRepository.findAllAndIsDeleted();
        List<StudentDto> studentDtos = new ArrayList<>();
        for(StudentEntity studentEntity : list){
            StudentDto studentDto1 = studentMapper.mapToDto(studentEntity);
            studentDtos.add(studentDto1);
        }

        return studentDtos;
    }

    public StudentEntity getStudentById(Long id) {
        return studentRepository.findByIdAndIsDeleted(id);
    }

    public StudentDto saveStudent(StudentDto studentDto) {
        StudentEntity studentEntity = studentMapper.mapToEntity(studentDto);
        DepartmentDto departmentDto;
        AddressDto addressDto;
        if (studentDto.getAddressDto() == null) {
            throw new RuntimeException("Please enter your address, not my address.");
        }
        else {
            AddressEntity addressEntity = addressMapper.mapToEntity(studentDto.getAddressDto());

            studentEntity.setAddressEntity(addressEntity);
            addressRepository.save(addressEntity);
            addressDto = addressMapper.mapToDto(addressEntity);
        }
        if (studentDto.getDepartmentDto() == null) {
            throw new RuntimeException("Please enter your department, not my department.");
        }
        else{
            DepartmentEntity departmentEntity = departmentMapper.mapToEntity(studentDto.getDepartmentDto());
            departmentRepository.save(departmentEntity);
            studentEntity.setDepartmentEntity(departmentEntity);
            departmentDto =  departmentMapper.mapToDto(departmentEntity);
        }
        studentRepository.save(studentEntity);

        StudentDto studentDto2 = studentMapper.mapToDto(studentEntity);
        studentDto2.setDepartmentDto(departmentDto);
        studentDto2.setAddressDto(addressDto);
        return studentDto2;

    }

    public void deleteStudent(Long id) {

        StudentEntity studentEntity = studentRepository.findById(id).get();
        studentEntity.setDeleted(true);
        studentRepository.save(studentEntity);
    }

}
