package com.intellicode.studentmanagementsystemapplication.repository;

import com.intellicode.studentmanagementsystemapplication.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    @Query("select c from CourseEntity c where (c.isDeleted is null or c.isDeleted = false) and c.id = :id")
    CourseEntity findByIdAndIsDeleted(@Param("id") Long id);

    @Query("select c from CourseEntity c where c.isDeleted is null or c.isDeleted = false")
    List<CourseEntity> findAllAndIsDeleted();




}
