package com.intellicode.studentmanagementsystemapplication.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "assessment")
public class AssessmentEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int marks;

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
