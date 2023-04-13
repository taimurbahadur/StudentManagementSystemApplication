package com.intellicode.studentmanagementsystemapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "course_assessment")
public class CourseHasAssessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int marks;

    // Bidirectional many-to-one relation for CourseHasAssessment and StudentHasCourse
    @ManyToOne
    @JoinColumn(name = "assessment_id", referencedColumnName = "id")
    private AssessmentEntity assessmentEntity;

    public AssessmentEntity getAssessmentEntity() {
        return assessmentEntity;
    }

    public void setAssessmentEntity(AssessmentEntity assessmentEntity) {
        this.assessmentEntity = assessmentEntity;
    }

    public CourseHasAssessment(AssessmentEntity assessmentEntity) {
        this.assessmentEntity = assessmentEntity;
    }

    // Bidirectional many-to-one relation for CourseHasAssessment and StudentHasCourse
    @ManyToOne
    @JoinColumn(name = "student_course_id", referencedColumnName = "id")
    @JsonIgnoreProperties("courseHasAssessments")
    private StudentHasCourse studentHasCourse;

    public StudentHasCourse getStudentHasCourse() {
        return studentHasCourse;
    }

    public void setStudentHasCourse(StudentHasCourse studentHasCourse) {
        this.studentHasCourse = studentHasCourse;
    }

    public CourseHasAssessment(StudentHasCourse studentHasCourse) {
        this.studentHasCourse = studentHasCourse;
    }

    public CourseHasAssessment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public CourseHasAssessment(Long id, int marks) {
        this.id = id;
        this.marks = marks;
    }
}
