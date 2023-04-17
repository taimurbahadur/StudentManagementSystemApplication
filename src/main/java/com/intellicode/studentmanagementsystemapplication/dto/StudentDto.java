package com.intellicode.studentmanagementsystemapplication.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private Date dob;
    private String gender;
    private AddressDto addressDto;
}
