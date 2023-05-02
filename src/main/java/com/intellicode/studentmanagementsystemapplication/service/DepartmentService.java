package com.intellicode.studentmanagementsystemapplication.service;

import com.intellicode.studentmanagementsystemapplication.dto.DepartmentDto;
import com.intellicode.studentmanagementsystemapplication.entity.DepartmentEntity;
import com.intellicode.studentmanagementsystemapplication.mapper.DepartmentMapper;
import com.intellicode.studentmanagementsystemapplication.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentDto> getAllDepartment() {

        List<DepartmentEntity> list = departmentRepository.findAllAndIsDeleted();
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        for (DepartmentEntity departmentEntity: list) {
            DepartmentDto departmentDto1 = departmentMapper.mapToDto(departmentEntity);
            departmentDtos.add(departmentDto1);
        }
        return departmentDtos;
    }

    public DepartmentEntity getDepartmentById(Long id) {
        return departmentRepository.findByIdAndIsDeleted(id);
    }

    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        DepartmentEntity departmentEntity= departmentMapper.mapToEntity(departmentDto);
        departmentRepository.save(departmentEntity);

        DepartmentDto departmentDto2 = departmentMapper.mapToDto(departmentEntity);
        return departmentDto2;
    }

    public void deleteDepartment(Long id) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id).get();
        departmentEntity.setDeleted(true);
        departmentRepository.save(departmentEntity);
    }
}
