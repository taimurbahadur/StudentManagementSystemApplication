package com.intellicode.studentmanagementsystemapplication.Repository;

import com.intellicode.studentmanagementsystemapplication.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    @Query("select s from StudentEntity s where s.isDeleted is null or s.isDeleted = false and s.id = :id")
    StudentEntity findByIdAndIsDeleted(@Param("id") Long id);

    @Query("select s from StudentEntity s where s.isDeleted is null or s.isDeleted = false")
    List<StudentEntity> findAllAndIsDeleted();




}
