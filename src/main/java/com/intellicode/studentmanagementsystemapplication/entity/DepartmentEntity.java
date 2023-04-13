package com.intellicode.studentmanagementsystemapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
public class DepartmentEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Bidirectional many-to-one relation for Department and Students
    @OneToMany(mappedBy = "departmentEntity")
    @JsonIgnoreProperties("departmentEntity")
    private Set<StudentEntity> studentEntities = new HashSet<>();

    public Set<StudentEntity> getStudentEntities() {
        return studentEntities;
    }

    public void setStudentEntities(Set<StudentEntity> studentEntities) {
        this.studentEntities = studentEntities;
    }



// Bidirectional one-to-many relation for Department and Courses

    @OneToMany(mappedBy = "departmentEntity")
    @JsonIgnoreProperties("departmentEntity")
    private Set<CourseEntity> courseEntities = new HashSet<>();

    public Set<CourseEntity> getCourseEntities() {
        return courseEntities;
    }

    public void setCourseEntities(Set<CourseEntity> courseEntities) {
        this.courseEntities = courseEntities;
    }

    public DepartmentEntity(Date createdDate, Date updatedDate, Boolean isDeleted, Integer updatedBy, Integer createdBy, Long id, String name, Set<StudentEntity> studentEntities, Set<CourseEntity> courseEntities) {
        super(createdDate, updatedDate, isDeleted, updatedBy, createdBy);
        this.id = id;
        this.name = name;
        this.studentEntities = studentEntities;
        this.courseEntities = courseEntities;
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
