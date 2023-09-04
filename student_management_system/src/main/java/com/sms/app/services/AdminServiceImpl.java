package com.sms.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.app.entities.Admin;
import com.sms.app.repositories.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public String adminLogin(String username, String password) {
        Admin admin = adminRepo.findByUsernameAndPassword(username, password);

        if (admin != null) {
            return "Admin login successful";
        }

        return "Invalid details";
    }

}
