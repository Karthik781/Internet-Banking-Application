package com.iba.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.iba.entity.UserEntity;
import com.iba.exception.UserNotFoundException;
import com.iba.pojo.AdminPojo;
import com.iba.pojo.UserPojo;
import com.iba.repository.UserRepository;

@Service
public class UserServiceImpl implements UserSevice{
	
	@Autowired
	public UserRepository userRepository;
	
	@Override
	public UserPojo addNewUser(UserPojo user) {
		
		UserEntity entity =  new UserEntity();
		
		BeanUtils.copyProperties(user, entity);
			
		UserEntity ue = userRepository.save(entity);
		
		BeanUtils.copyProperties(ue, user);
		
		return user;
		
	}

	@Override
	public UserEntity signIn(UserEntity user) {
		return null;
	}

	@Override
	public UserEntity signOut(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPojo updateUserInfo(UserPojo user) {
	UserEntity entity =  new UserEntity();
		
		BeanUtils.copyProperties(user, entity);
			
		UserEntity ue = userRepository.save(entity);
		
		BeanUtils.copyProperties(ue, user);
		
		return user;
	}

	@Override
	public boolean deleteUserInfo(long userId) {
          
		return false;
	}

	@Override
	public List<UserPojo> ListAllUsers() {
		
		List<UserEntity> user = userRepository.findAll();
		
		List<UserPojo> userPojos = new ArrayList<UserPojo>();
		
		for(UserEntity entity : user) {
			UserPojo up = new UserPojo();
			
			BeanUtils.copyProperties(entity, up);
			
			userPojos.add(up);
	
		}
		
		return userPojos;
		
//		return userRepository.findAll();
	}

	@Override
	public UserPojo getUserById(long userId) {
		
		Optional<UserEntity> user = userRepository.findById(userId);
		
		if(user.isPresent() == false) {
			throw new UserNotFoundException("User Not Found with ID!");
		}
		
		UserEntity entity =  user.get();	
		UserPojo pojo = new AdminPojo();
		BeanUtils.copyProperties(entity, pojo);
		
		return pojo;
	}

}
