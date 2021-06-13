package com.iba.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iba.entity.AdminEntity;
import com.iba.entity.UserEntity;
import com.iba.pojo.AdminPojo;
import com.iba.service.AdminService;
import com.iba.service.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/all")
	public List<AdminPojo> getAllAdmins(){
		return adminService.ListAllAdmins();
	}
	
	@GetMapping("/{id}")
	public AdminPojo getAdminById(@PathVariable("id") long adminId) {
		return adminService.findAdminById(adminId);
	}
	
	@PostMapping("/create")
	public AdminPojo createNewAdmin(@Valid @RequestBody AdminPojo admin) {
		return adminService.addAdmin(admin);
	}
	
	@PutMapping("/update")
	public AdminPojo updateAdmin(@Valid @RequestBody AdminPojo admin)
	{
		return adminService.updateAdmin(admin);
	}
	
	@DeleteMapping("/delete/{adminId}")
	public boolean deleteAdmin(@PathVariable("adminId") int adminId) {
		return adminService.removeAdmin(adminId);
	}
}
