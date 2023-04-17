package com.intellicode.studentmanagementsystemapplication.repository;

import com.intellicode.studentmanagementsystemapplication.entity.CourseHasAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseHasAssessmentRepository extends JpaRepository<CourseHasAssessment, Long> {
    @Query("select c from CourseHasAssessment c where c.isDeleted is null or c.isDeleted = false and c.id = :id")
    CourseHasAssessment findByIdAndIsDeleted(@Param("id") Long id);

    @Query("select c from CourseHasAssessment c where c.isDeleted is null or c.isDeleted = false")
    List<CourseHasAssessment> findAllAndIsDeleted();


}
