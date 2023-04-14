package com.intellicode.studentmanagementsystemapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name="students")
public class StudentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date dob;
    private String gender;

    // Bidirectional one-to-many relation for Student and StudentHasCourse

    @OneToMany(mappedBy = "studentEntity")
    @JsonIgnoreProperties("studentEntity")
    private Set<StudentHasCourse> studentHasCourses = new HashSet<>();

    public Set<StudentHasCourse> getStudentHasCourses() {
        return studentHasCourses;
    }

    public void setStudentHasCourses(Set<StudentHasCourse> studentHasCourses) {
        this.studentHasCourses = studentHasCourses;
    }

    public StudentEntity(Date createdDate, Date updatedDate, Boolean isDeleted, Integer updatedBy, Integer createdBy, Set<StudentHasCourse> studentHasCourses) {
        super(createdDate, updatedDate, isDeleted, updatedBy, createdBy);
        this.studentHasCourses = studentHasCourses;
    }

    // Bidirectional one-to-one relation for Students and Address
    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)

    private AddressEntity addressEntity;

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public StudentEntity(Date createdDate, Date updatedDate, Boolean isDeleted, Integer updatedBy, Integer createdBy, Long id, String name, Date dob, String gender, AddressEntity addressEntity) {
        super(createdDate, updatedDate, isDeleted, updatedBy, createdBy);
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.addressEntity = addressEntity;
    }

    // Bidirectional one-to-one relation for Students and Department
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    @JsonIgnoreProperties("studentEntity")

    private DepartmentEntity departmentEntity;

    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }

    public StudentEntity(Date createdDate, Date updatedDate, Boolean isDeleted, Integer updatedBy, Integer createdBy, DepartmentEntity departmentEntity) {
        super(createdDate, updatedDate, isDeleted, updatedBy, createdBy);
        this.departmentEntity = departmentEntity;
    }

    public StudentEntity(){

    }

    public StudentEntity(Long id, String name, Date dob, String gender) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
