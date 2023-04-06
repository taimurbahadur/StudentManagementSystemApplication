package com.intellicode.studentmanagementsystemapplication.Service;

import com.intellicode.studentmanagementsystemapplication.Entity.DepartmentEntity;
import com.intellicode.studentmanagementsystemapplication.Repository.DepartmentRepository;
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

    public List<DepartmentEntity> getAllDepartment(){
        return departmentRepository.findAll();
    }

    public DepartmentEntity getDepartmentById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }

    public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity){
        return departmentRepository.save(departmentEntity);
    }

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }
}
