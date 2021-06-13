package com.iba.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iba.entity.UserEntity;
import com.iba.pojo.UserPojo;
import com.iba.service.UserSevice;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserSevice userSevice;
	
	@GetMapping("/all")
	public List<UserPojo> getAllUsers() {
		return userSevice.ListAllUsers();
	}
	
	@PostMapping("/create")
	public UserPojo addUser(@Valid @RequestBody UserPojo user) {
		return userSevice.addNewUser(user);
	}

	@PutMapping("/create")
	public UserPojo updateUser(@Valid @RequestBody UserPojo user) {
		return userSevice.updateUserInfo(user);
	}
	
	@GetMapping("/{id}")
	public UserPojo getUserById(@PathVariable("id") long userId) {
		return userSevice.getUserById(userId);
	}
	

}
