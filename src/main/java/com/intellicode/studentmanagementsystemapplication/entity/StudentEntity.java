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
//    private String gender1;


    @OneToOne(mappedBy = "studentEntity", cascade = CascadeType.ALL)

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

    @OneToMany(mappedBy = "studentEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DepartmentEntity> departmentEntity = new HashSet<>();

    public Set<DepartmentEntity> getDepartmentEntities() {
        return departmentEntity;
    }

    public void setDepartmentEntities(Set<DepartmentEntity> departmentEntities) {
        this.departmentEntity = departmentEntities;
    }

    public StudentEntity(Date createdDate, Date updatedDate, Boolean isDeleted, Integer updatedBy, Integer createdBy, Set<DepartmentEntity> departmentEntities) {
        super(createdDate, updatedDate, isDeleted, updatedBy, createdBy);
        this.departmentEntity = departmentEntities;
    }

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    @JsonIgnoreProperties("students")
    private List<CourseEntity> courseEntity = new ArrayList<>();

    public List<CourseEntity> getCourseEntity() {
        return courseEntity;
    }

    public void setCourseEntity(List<CourseEntity> courseEntity) {
        this.courseEntity = courseEntity;
    }

    public StudentEntity(Date createdDate, Date updatedDate, Boolean isDeleted, Integer updatedBy, Integer createdBy, List<CourseEntity> courseEntity) {
        super(createdDate, updatedDate, isDeleted, updatedBy, createdBy);
        this.courseEntity = courseEntity;
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
