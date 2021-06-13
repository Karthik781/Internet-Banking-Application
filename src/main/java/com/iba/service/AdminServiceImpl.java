package com.iba.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iba.entity.AdminEntity;
import com.iba.entity.UserEntity;
import com.iba.exception.AdminNotFoundException;
import com.iba.exception.UserNotFoundException;
import com.iba.pojo.AdminPojo;
import com.iba.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Override
	public AdminPojo findAdminById(long adminId) {
		Optional<AdminEntity> result = adminRepository.findById(adminId);
		if (result.isPresent() == false) {
			throw new AdminNotFoundException("Admin with ID:" + adminId + " not found");
		}
		if (result.isPresent()) {
			AdminPojo pojo = new AdminPojo();
			AdminEntity entity = result.get();
			BeanUtils.copyProperties(entity, pojo);
			return pojo;
		}
		return null;

	}

	@Override
	public AdminPojo updateAdmin(AdminPojo admin) {

		if (admin.equals(null)) {
			throw new AdminNotFoundException("Cannot update with empty object!");
		}

		AdminEntity entity = new AdminEntity();

		BeanUtils.copyProperties(admin, entity);

		AdminEntity e = adminRepository.save(entity);

		BeanUtils.copyProperties(e, admin);

		return admin;
//		return adminRepository.save(admin);
	}

	@Override
	public boolean removeAdmin(long adminId) {
		adminRepository.deleteById(adminId);
		return true;
	}

	@Override
	public List<AdminPojo> ListAllAdmins() {
		List<AdminEntity> adminEntities = adminRepository.findAll();
		
		if(adminEntities.isEmpty()) {
			throw new AdminNotFoundException("No admins found");
		}
		
		List<AdminPojo> adminpojos = new ArrayList<AdminPojo>();
		for (AdminEntity entity : adminEntities) {
			AdminPojo adminPojo = new AdminPojo();
			BeanUtils.copyProperties(entity, adminPojo);
			adminpojos.add(adminPojo);
		}
		return adminpojos;
	}

	@Override
	public AdminPojo addAdmin(AdminPojo admin) {

		AdminEntity entity = new AdminEntity();

		BeanUtils.copyProperties(admin, entity);

		AdminEntity e = adminRepository.save(entity);

		if (e.equals(null)) {
			throw new UserNotFoundException("Unable to add admin!");
		}

		BeanUtils.copyProperties(e, admin);

		return admin;
	}

}
