package com.intellicode.studentmanagementsystemapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "assessment")
public class AssessmentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    private int marks;

    // Bidirectional one-to-many relation for Assessments and CourseHasAssessment

    @OneToMany(mappedBy = "assessmentEntity")
    @JsonIgnoreProperties("studentEntity")
    private Set<CourseHasAssessment> courseHasAssessments = new HashSet<>();

    public Set<CourseHasAssessment> getCourseHasAssessments() {
        return courseHasAssessments;
    }

    public void setCourseHasAssessments(Set<CourseHasAssessment> courseHasAssessments) {
        this.courseHasAssessments = courseHasAssessments;
    }

    public AssessmentEntity(Date createdDate, Date updatedDate, Boolean isDeleted, Integer updatedBy, Integer createdBy, Set<CourseHasAssessment> courseHasAssessments) {
        super(createdDate, updatedDate, isDeleted, updatedBy, createdBy);
        this.courseHasAssessments = courseHasAssessments;
    }

    // Bidirectional many-to-one relation for Assessments and Courses
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @JsonIgnoreProperties("assessmentEntities")
    private CourseEntity courseEntity;

    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
    }

    public AssessmentEntity() {
    }

    public AssessmentEntity(Long id, String name, int marks) {
        this.id = id;
        this.name = name;
//        this.marks = marks;
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

//    public int getMarks() {
//        return marks;
//    }

//    public void setMarks(int marks) {
//        this.marks = marks;
//    }
}
