package com.intellicode.studentmanagementsystemapplication.controller;

import com.intellicode.studentmanagementsystemapplication.entity.DepartmentEntity;
import com.intellicode.studentmanagementsystemapplication.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<DepartmentEntity> getAllDeparment(){
        return departmentService.getAllDepartment();
    }

    @GetMapping("/{id}")
    public DepartmentEntity getDepartmentById(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public DepartmentEntity saveDepartment(@RequestBody DepartmentEntity departmentEntity){
        return departmentService.saveDepartment(departmentEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
    }
}
