package com.intellicode.studentmanagementsystemapplication.Repository;

import com.intellicode.studentmanagementsystemapplication.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
