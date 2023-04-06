package com.intellicode.studentmanagementsystemapplication.Service;

import com.intellicode.studentmanagementsystemapplication.Entity.AddressEntity;
import com.intellicode.studentmanagementsystemapplication.Repository.AddressRepository;
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
        return addressRepository.findAll();
    }

    public AddressEntity getAddressById(Long id){
        return addressRepository.findById(id).orElse(null);
    }

    public AddressEntity saveAddress(AddressEntity addressEntity){
        return addressRepository.save(addressEntity);
    }
    public void deleteAddress(Long id){
        addressRepository.deleteById(id);
    }

}
