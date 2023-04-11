package com.intellicode.studentmanagementsystemapplication.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "assessment")
public class AssessmentEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int marks;

    // Bidirectional one-to-many relation for Assessments and Courses
    @OneToMany(mappedBy = "assessmentEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CourseEntity> courseEntitySet = new HashSet<>();

    public Set<CourseEntity> getCourseEntitySet() {
        return courseEntitySet;
    }

    public void setCourseEntitySet(Set<CourseEntity> courseEntitySet) {
        this.courseEntitySet = courseEntitySet;
    }

    public AssessmentEntity(Date createdDate, Date updatedDate, Boolean isDeleted, Integer updatedBy, Integer createdBy, Set<CourseEntity> courseEntitySet) {
        super(createdDate, updatedDate, isDeleted, updatedBy, createdBy);
        this.courseEntitySet = courseEntitySet;
    }

    public AssessmentEntity() {
    }

    public AssessmentEntity(Long id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
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

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
