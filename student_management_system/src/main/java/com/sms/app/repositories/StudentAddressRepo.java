package com.sms.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.app.entities.StudentAddress;

public interface StudentAddressRepo extends JpaRepository<StudentAddress, Long> {

}
