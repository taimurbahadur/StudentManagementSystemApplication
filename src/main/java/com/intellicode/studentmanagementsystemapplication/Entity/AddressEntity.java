package com.intellicode.studentmanagementsystemapplication.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int houseNo;
    private String street;
    private String city;
    private String country;

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
