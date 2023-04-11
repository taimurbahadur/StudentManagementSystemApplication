package com.intellicode.studentmanagementsystemapplication.service;

import com.intellicode.studentmanagementsystemapplication.entity.AddressEntity;
import com.intellicode.studentmanagementsystemapplication.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressEntity> getAllAddresses(){
        return addressRepository.findAllAndIsDeleted();
    }

    public AddressEntity getAddressById(Long id){
        return addressRepository.findByIdAndIsDeleted(id);
    }

    public AddressEntity saveAddress(AddressEntity addressEntity){
        return addressRepository.save(addressEntity);
    }
    public void deleteAddress(Long id){
        AddressEntity addressEntity = addressRepository.findById(id).get();
        addressEntity.setDeleted(true);
        addressRepository.save(addressEntity);
    }

}
