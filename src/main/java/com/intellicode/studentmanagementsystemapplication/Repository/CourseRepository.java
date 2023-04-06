package com.intellicode.studentmanagementsystemapplication.Repository;

import com.intellicode.studentmanagementsystemapplication.Entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
