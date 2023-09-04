package com.sms.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.app.services.AdminService;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/admin/login/{username}/{password}")
    public String adminLogin(@PathVariable String username, @PathVariable String password) {
        return adminService.adminLogin(username, password);
    }
}
