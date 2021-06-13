package com.iba.service;

import java.util.List;

import javax.validation.Valid;

import com.iba.entity.UserEntity;
import com.iba.pojo.UserPojo;

public interface UserSevice {

	public List<UserPojo> ListAllUsers();
	public UserPojo addNewUser(UserPojo user) ;
	public UserEntity signIn(UserEntity user);
	public UserEntity signOut(UserEntity user) ;
	public UserPojo updateUserInfo(@Valid UserPojo user) ;
	public boolean deleteUserInfo(long userId);
	
	public UserPojo getUserById(long userId);
	
}
