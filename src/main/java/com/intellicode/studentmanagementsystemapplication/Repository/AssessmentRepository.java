package com.intellicode.studentmanagementsystemapplication.Repository;

import com.intellicode.studentmanagementsystemapplication.Entity.AssessmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepository extends JpaRepository<AssessmentEntity,Long> {
}
