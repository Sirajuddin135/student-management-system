package com.sms.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sms.app.entities.Admin;
import com.sms.app.repositories.AdminRepo;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	@Autowired
	private AdminRepo adminRepo;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Admin admin = new Admin();
		admin.setUsername("Admin");
		admin.setPassword("Admin123");

		Admin savedAdmin = adminRepo.save(admin);

		System.out.println("Admin created with details: ");
		System.out.println("Username: " + savedAdmin.getUsername());
		System.out.println("Pasword: " + savedAdmin.getPassword());
	}

}
