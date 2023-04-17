package com.intellicode.studentmanagementsystemapplication.service;

import com.intellicode.studentmanagementsystemapplication.entity.DepartmentEntity;
import com.intellicode.studentmanagementsystemapplication.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentEntity> getAllDepartment() {
        return departmentRepository.findAllAndIsDeleted();
    }

    public DepartmentEntity getDepartmentById(Long id) {
        return departmentRepository.findByIdAndIsDeleted(id);
    }

    public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    public void deleteDepartment(Long id) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id).get();
        departmentEntity.setDeleted(true);
        departmentRepository.save(departmentEntity);
    }
}
