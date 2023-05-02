package com.intellicode.studentmanagementsystemapplication.mapper;

import com.intellicode.studentmanagementsystemapplication.dto.StudentDto;
import com.intellicode.studentmanagementsystemapplication.entity.StudentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    private ModelMapper mapper;

    public StudentMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    // Convert Entity to DTO
    public StudentDto mapToDto(StudentEntity studentEntity) {
        StudentDto studentDto = mapper.map(studentEntity, StudentDto.class);


//        StudentDto studentDto = new StudentDto();
//        studentDto.setId(studentEntity.getId());
//        studentDto.setName(studentEntity.getName());
//        studentDto.setDob(studentEntity.getDob());
//        studentDto.setGender(studentEntity.getGender());
        return studentDto;
    }

    // Convert DTO to Entity
    public StudentEntity mapToEntity(StudentDto studentDto) {
       StudentEntity studentEntity = mapper.map(studentDto, StudentEntity.class);

//        StudentEntity studentEntity = new StudentEntity();
//        studentEntity.setId(studentDto.getId());
//        studentEntity.setName(studentDto.getName());
//        studentEntity.setDob(studentDto.getDob());
//        studentEntity.setGender(studentDto.getGender());
        return studentEntity;
    }
}
