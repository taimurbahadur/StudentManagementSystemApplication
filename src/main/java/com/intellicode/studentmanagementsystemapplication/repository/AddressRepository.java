package com.intellicode.studentmanagementsystemapplication.repository;

import com.intellicode.studentmanagementsystemapplication.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
    @Query("select a from AddressEntity a where (a.isDeleted is null or a.isDeleted = false) and a.id = :id")
    AddressEntity findByIdAndIsDeleted(@Param("id") Long id);

    @Query("select a from AddressEntity a where a.isDeleted is null or a.isDeleted = false")
    List<AddressEntity> findAllAndIsDeleted();


}
