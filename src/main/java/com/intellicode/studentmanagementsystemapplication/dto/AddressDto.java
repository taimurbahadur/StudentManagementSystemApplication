package com.intellicode.studentmanagementsystemapplication.dto;

import lombok.Data;

@Data
public class AddressDto {
    private Long id;
    private int houseNo;
    private String street;
    private String city;
    private String country;
}
