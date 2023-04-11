package com.intellicode.studentmanagementsystemapplication.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "department")
public class DepartmentEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Bidirectional many-to-one relation for Department and Courses
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private CourseEntity courseEntity;

    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
    }

    public DepartmentEntity(Date createdDate, Date updatedDate, Boolean isDeleted, Integer updatedBy, Integer createdBy, CourseEntity courseEntity) {
        super(createdDate, updatedDate, isDeleted, updatedBy, createdBy);
        this.courseEntity = courseEntity;
    }

    // Bidirectional many-to-one relation for Department and Students
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity studentEntity;

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public DepartmentEntity(Date createdDate, Date updatedDate, Boolean isDeleted, Integer updatedBy, Integer createdBy, StudentEntity studentEntity) {
        super(createdDate, updatedDate, isDeleted, updatedBy, createdBy);
        this.studentEntity = studentEntity;
    }

    public DepartmentEntity() {
    }

    public DepartmentEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
