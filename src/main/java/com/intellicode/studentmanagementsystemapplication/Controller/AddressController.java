package com.intellicode.studentmanagementsystemapplication.Controller;

import com.intellicode.studentmanagementsystemapplication.Entity.AddressEntity;
import com.intellicode.studentmanagementsystemapplication.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<AddressEntity> getAllAddresses(){
        return addressService.getAllAddresses();
    }
    @GetMapping("/{id}")
    public AddressEntity getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }

    @PostMapping
    public AddressEntity saveAddress(@RequestBody AddressEntity addressEntity){
        return addressService.saveAddress(addressEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
    }


}
