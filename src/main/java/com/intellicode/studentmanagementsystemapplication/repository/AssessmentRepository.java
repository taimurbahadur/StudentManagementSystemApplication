package com.intellicode.studentmanagementsystemapplication.repository;

import com.intellicode.studentmanagementsystemapplication.entity.AssessmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentRepository extends JpaRepository<AssessmentEntity, Long> {
    @Query("select a from AssessmentEntity a where (a.isDeleted is null or a.isDeleted = false) and a.id = :id")
    AssessmentEntity findByIdAndIsDeleted(@Param("id") Long id);

    @Query("select a from AssessmentEntity a where a.isDeleted is null or a.isDeleted = false")
    List<AssessmentEntity> findAllAndIsDeleted();


}
