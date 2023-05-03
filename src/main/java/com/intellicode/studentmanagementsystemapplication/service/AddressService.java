package com.intellicode.studentmanagementsystemapplication.service;

import com.intellicode.studentmanagementsystemapplication.dto.AddressDto;
import com.intellicode.studentmanagementsystemapplication.entity.AddressEntity;
import com.intellicode.studentmanagementsystemapplication.mapper.AddressMapper;
import com.intellicode.studentmanagementsystemapplication.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressMapper addressMapper;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressDto> getAllAddresses() {
        List<AddressEntity> list = addressRepository.findAllAndIsDeleted();
        List<AddressDto> addressDtos = new ArrayList<>();
        for(AddressEntity addressEntity : list){
            AddressDto addressDto = addressMapper.mapToDto(addressEntity);
            addressDtos.add(addressDto);
        }
        return addressDtos;
    }

    public AddressDto getAddressById(Long id) {
        AddressEntity addressEntity = addressRepository.findByIdAndIsDeleted(id);
        AddressDto addressDto = addressMapper.mapToDto(addressEntity);
        return addressDto;
    }

    public AddressDto saveAddress(AddressDto addressDto) {
        AddressEntity addressEntity = addressMapper.mapToEntity(addressDto);
        addressRepository.save(addressEntity);

        AddressDto addressDto1 = addressMapper.mapToDto(addressEntity);
        return addressDto1;
    }

    public void deleteAddress(Long id) {
        AddressEntity addressEntity = addressRepository.findById(id).get();
        addressEntity.setDeleted(true);
        addressRepository.save(addressEntity);
    }

}
