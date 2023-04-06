package com.intellicode.studentmanagementsystemapplication.Repository;

import com.intellicode.studentmanagementsystemapplication.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
}
