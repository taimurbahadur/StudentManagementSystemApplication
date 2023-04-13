package com.intellicode.studentmanagementsystemapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student_course")
public class StudentHasCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String grade;

    // Bidirectional one-to-many relation for StudentHasCourse and CourseHasAssessment

    @OneToMany(mappedBy = "studentHasCourse")
    @JsonIgnoreProperties("studentHasCourse")
    private Set<CourseHasAssessment> courseHasAssessments =new HashSet<>();

    public Set<CourseHasAssessment> getCourseHasAssessments() {
        return courseHasAssessments;
    }

    public void setCourseHasAssessments(Set<CourseHasAssessment> courseHasAssessments) {
        this.courseHasAssessments = courseHasAssessments;
    }

    public StudentHasCourse(Set<CourseHasAssessment> courseHasAssessments) {
        this.courseHasAssessments = courseHasAssessments;
    }

    // Bidirectional many-to-one relation for StudentHasCourse and Course
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @JsonIgnoreProperties("studentHasCourses")
    private CourseEntity courseEntity;

    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
    }

    public StudentHasCourse(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
    }

    // Bidirectional many-to-one relation for StudentHasCourse and Students
    @ManyToOne
    @JoinColumn(name = "students_id", referencedColumnName = "id")
    @JsonIgnoreProperties("studentHasCourses")
    private StudentEntity studentEntity;

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public StudentHasCourse(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public StudentHasCourse() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public StudentHasCourse(Long id, String grade) {
        this.id = id;
        this.grade = grade;
    }
}
