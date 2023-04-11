package com.intellicode.studentmanagementsystemapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "course")
public class CourseEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String grade;

    // Bidirectional many-to-one relation for Courses and Department
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private DepartmentEntity departmentEntity;

    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }

    public CourseEntity(Date createdDate, Date updatedDate, Boolean isDeleted, Integer updatedBy, Integer createdBy, DepartmentEntity departmentEntity) {
        super(createdDate, updatedDate, isDeleted, updatedBy, createdBy);
        this.departmentEntity = departmentEntity;
    }

    // Bidirectional many-to-one relation for Courses and Assessments
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assessment_id", nullable = false)
    private AssessmentEntity assessmentEntity;

    public AssessmentEntity getAssessmentEntity() {
        return assessmentEntity;
    }

    public void setAssessmentEntity(AssessmentEntity assessmentEntity) {
        this.assessmentEntity = assessmentEntity;
    }

    public CourseEntity(Date createdDate, Date updatedDate, Boolean isDeleted, Integer updatedBy, Integer createdBy, AssessmentEntity assessmentEntity) {
        super(createdDate, updatedDate, isDeleted, updatedBy, createdBy);
        this.assessmentEntity = assessmentEntity;
    }

    // Bidirectional many-to-many relation for Students and Courses
    @ManyToMany(mappedBy = "courseEntity", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("courses")
    private List<StudentEntity> students = new ArrayList<>();

    public CourseEntity(Date createdDate, Date updatedDate, Boolean isDeleted, Integer updatedBy, Integer createdBy, List<StudentEntity> students) {
        super(createdDate, updatedDate, isDeleted, updatedBy, createdBy);
        this.students = students;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }

    public CourseEntity() {
    }

    public CourseEntity(Long id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
