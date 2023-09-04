package com.sms.app.services;

import java.util.List;

import com.sms.app.entities.StudentAddress;

public interface StudentAddressService {
    List<StudentAddress> getAddresses();

    StudentAddress createAddress(StudentAddress ad);

    StudentAddress updateAddress(StudentAddress ad);

    String deleteAddress(StudentAddress ad);
}
