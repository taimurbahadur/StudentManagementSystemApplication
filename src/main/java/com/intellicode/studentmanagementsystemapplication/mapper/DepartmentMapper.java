package com.intellicode.studentmanagementsystemapplication.mapper;

import com.intellicode.studentmanagementsystemapplication.dto.DepartmentDto;
import com.intellicode.studentmanagementsystemapplication.entity.DepartmentEntity;

public class DepartmentMapper {

    // Convert Entity to DTO
    public DepartmentDto mapToDto(DepartmentEntity departmentEntity) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(departmentEntity.getId());
        departmentDto.setName(departmentEntity.getName());
        return departmentDto;
    }

    // Convert DTO to Entity
    public DepartmentEntity mapToEntity(DepartmentDto departmentDto) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(departmentDto.getId());
        departmentEntity.setName(departmentDto.getName());
        return departmentEntity;
    }
}
