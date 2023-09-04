package com.sms.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.app.entities.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long> {

    Admin findByUsernameAndPassword(String username, String password);
}
