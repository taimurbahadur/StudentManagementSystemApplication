package com.intellicode.studentmanagementsystemapplication.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "address")
public class AddressEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int houseNo;
    private String street;
    private String city;
    private String country;

    @OneToOne(mappedBy = "addressEntity", cascade = CascadeType.ALL)

    private StudentEntity studentEntity;

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public AddressEntity(Date createdDate, Date updatedDate, Boolean isDeleted, Integer updatedBy, Integer createdBy, StudentEntity studentEntity) {
        super(createdDate, updatedDate, isDeleted, updatedBy, createdBy);
        this.studentEntity = studentEntity;
    }

    public AddressEntity() {
    }

    public AddressEntity(Long id, int houseNo, String street, String city, String country) {
        this.id = id;
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
