package com.intellicode.studentmanagementsystemapplication.repository;

import com.intellicode.studentmanagementsystemapplication.entity.StudentHasCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentHasCourseRepository extends JpaRepository<StudentHasCourse, Long> {
    @Query("select s from StudentHasCourse s where s.isDeleted is null or s.isDeleted = false and s.id = :id")
    StudentHasCourse findByIdAndIsDeleted(@Param("id") Long id);

    @Query("select s from StudentHasCourse s where s.isDeleted is null or s.isDeleted = false")
    List<StudentHasCourse> findAllAndIsDeleted();


}
