package com.intellicode.studentmanagementsystemapplication.Repository;

import com.intellicode.studentmanagementsystemapplication.Entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
