package com.iba.service;

import java.util.List;

import com.iba.entity.AdminEntity;
import com.iba.entity.UserEntity;
import com.iba.pojo.AdminPojo;

public interface AdminService {
	
	public AdminPojo  addAdmin(AdminPojo admin) ;
	public AdminPojo findAdminById(long adminId) ;
	public AdminPojo updateAdmin(AdminPojo admin)  ;
	public boolean removeAdmin(long adminId) ;
	public List<AdminPojo> ListAllAdmins() ;

}
