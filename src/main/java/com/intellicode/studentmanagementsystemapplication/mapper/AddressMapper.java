package com.intellicode.studentmanagementsystemapplication.mapper;

import com.intellicode.studentmanagementsystemapplication.dto.AddressDto;
import com.intellicode.studentmanagementsystemapplication.entity.AddressEntity;

public class AddressMapper {

    // Convert Entity to DTO
    public AddressDto mapToDto(AddressEntity addressEntity) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(addressEntity.getId());
        addressDto.setHouseNo(addressEntity.getHouseNo());
        addressDto.setStreet(addressEntity.getStreet());
        addressDto.setCity(addressEntity.getCity());
        addressDto.setCountry(addressEntity.getCountry());
        return addressDto;
    }

    // Convert DTO to Entity
    public AddressEntity mapToEntity(AddressDto addressDto) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(addressDto.getId());
        addressEntity.setHouseNo(addressDto.getHouseNo());
        addressEntity.setStreet(addressDto.getStreet());
        addressEntity.setCity(addressDto.getCity());
        return addressEntity;
    }
}
