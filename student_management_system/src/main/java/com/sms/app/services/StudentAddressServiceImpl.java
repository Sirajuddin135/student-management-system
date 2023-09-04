package com.sms.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.app.entities.StudentAddress;
import com.sms.app.repositories.StudentAddressRepo;

@Service
public class StudentAddressServiceImpl implements StudentAddressService {

    @Autowired
    private StudentAddressRepo studentAddressRepo;

    @Override
    public List<StudentAddress> getAddresses() {
        return studentAddressRepo.findAll();
    }

    @Override
    public StudentAddress createAddress(StudentAddress ad) {
        return studentAddressRepo.save(ad);
    }

    @Override
    public StudentAddress updateAddress(StudentAddress ad) {
        return studentAddressRepo.save(ad);
    }

    @Override
    public String deleteAddress(StudentAddress ad) {
        studentAddressRepo.delete(ad);

        return "Address deleted successfully";
    }

}
