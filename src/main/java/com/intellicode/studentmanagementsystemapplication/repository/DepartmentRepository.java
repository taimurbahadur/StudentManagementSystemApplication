package com.intellicode.studentmanagementsystemapplication.repository;

import com.intellicode.studentmanagementsystemapplication.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    @Query("select d from DepartmentEntity d where (d.isDeleted is null or d.isDeleted =false) and d.id =:id")
    DepartmentEntity findByIdAndIsDeleted(@Param("id") Long id);

    @Query("select d from DepartmentEntity d where d.isDeleted is null or d.isDeleted = false")
    List<DepartmentEntity> findAllAndIsDeleted();


}
