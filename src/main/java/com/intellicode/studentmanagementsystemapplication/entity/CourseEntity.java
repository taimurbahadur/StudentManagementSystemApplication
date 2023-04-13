package com.intellicode.studentmanagementsystemapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "course")
public class CourseEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    private String grade;

    // Bidirectional one-to-many relation for Course and StudentHasCourse

    @OneToMany(mappedBy = "courseEntity")
    @JsonIgnoreProperties("courseEntity")
    private Set<StudentHasCourse> studentHasCourses = new HashSet<>();

    public Set<StudentHasCourse> getStudentHasCourses() {
        return studentHasCourses;
    }

    public void setStudentHasCourses(Set<StudentHasCourse> studentHasCourses) {
        this.studentHasCourses = studentHasCourses;
    }


    // Bidirectional many-to-one relation for Courses and Department
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    @JsonIgnoreProperties("courseEntity")
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

    // Bidirectional one-to-many relation for Courses and Assessments

    @OneToMany(mappedBy = "courseEntity")
    @JsonIgnoreProperties("courseEntity")
    private Set<AssessmentEntity> assessmentEntities = new HashSet<>();

    public Set<AssessmentEntity> getAssessmentEntities() {
        return assessmentEntities;
    }

    public void setAssessmentEntities(Set<AssessmentEntity> assessmentEntities) {
        this.assessmentEntities = assessmentEntities;
    }

    public CourseEntity(Date createdDate, Date updatedDate, Boolean isDeleted, Integer updatedBy, Integer createdBy, Set<AssessmentEntity> assessmentEntities) {
        super(createdDate, updatedDate, isDeleted, updatedBy, createdBy);
        this.assessmentEntities = assessmentEntities;
    }

    public CourseEntity() {
    }

    public CourseEntity(Long id, String name, String grade) {
        this.id = id;
        this.name = name;
//        this.grade = grade;
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

//    public String getGrade() {
//        return grade;
//    }

//    public void setGrade(String grade) {
//        this.grade = grade;
//    }
}
