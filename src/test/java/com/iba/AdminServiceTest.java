package com.iba;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;

import com.iba.entity.AdminEntity;
import com.iba.exception.CustomerNotFoundException;
import com.iba.pojo.AdminPojo;
import com.iba.repository.AdminRepository;
import com.iba.service.AdminService;
import com.iba.service.AdminServiceImpl;


public class AdminServiceTest {
	@InjectMocks
	AdminService adminService= new AdminServiceImpl();
	
	@Mock
	AdminRepository adminRepository;
	
	@Test
	public void testGetAllCustomers() {
		
		List<AdminEntity> mockCustomers = new ArrayList<AdminEntity>();
		
		mockCustomers.add(new AdminEntity("gvw124","admin", "maria", "567567", "maria@mail.com"));
		mockCustomers.add(new AdminEntity("12312","admin", "tom", "98989569", "karth@mail.com"));
		mockCustomers.add(new AdminEntity("fdvd123","admin", "kedam", "89457845", "kedam@mail.com"));
		
		Mockito.when(adminRepository.findAll()).thenReturn(mockCustomers);
		
		assertEquals(3, adminService.ListAllAdmins().size());
	}
	
	@Test
	public void testAddCustomer() {
		
		AdminPojo mockArgumentCustomer = new AdminPojo();
		mockArgumentCustomer.setAdminName("maria");
		mockArgumentCustomer.setAdminEmailId("maria@mail.com");
		mockArgumentCustomer.setType("female");
		mockArgumentCustomer.setAdminContact("8548484884");
		
		
		AdminEntity mockEntity = new AdminEntity();
		mockEntity.setUserId(100);
		mockEntity.setAdminName("maria");
		mockEntity.setAdminEmailId("maria@mail.com");
		mockEntity.setType("female");
		mockEntity.setAdminContact("8548484884");
		
		BeanUtils.copyProperties(mockArgumentCustomer, mockEntity);
		
		Mockito.when(adminRepository.save(Mockito.any(AdminEntity.class))).thenReturn(mockEntity);
		
		assertEquals("maria", adminService.addAdmin(mockArgumentCustomer).getAdminName());
	}
	

	
	@Test
	public void testfindCustomerByIdException() {
		Optional<AdminEntity> courseEntity = Optional.empty();
		
		AdminPojo mockArgumentCustomer = new AdminPojo();
		mockArgumentCustomer.setAdminName("maria");
		mockArgumentCustomer.setAdminEmailId("maria@mail.com");
		mockArgumentCustomer.setType("female");
		mockArgumentCustomer.setAdminContact("8548484884");
		
		Mockito.when(adminRepository.findById(Mockito.anyLong())).thenReturn(courseEntity);

		Exception exception = assertThrows(CustomerNotFoundException.class,	() -> adminService.findAdminById(20));

		assertEquals("Admin with Id not found", exception.getMessage());
		
	}
	
//	@Test
//	public void testAddCustomerException() {
//		CustomerEntity customerEntity = null;
//		
//		CustomerPojo mockArgumentCustomer = new CustomerPojo();
//		mockArgumentCustomer.setAge(20);
//		mockArgumentCustomer.setCustomerName("maria");
//		mockArgumentCustomer.setEmailId("maria@mail.com");
//		mockArgumentCustomer.setGender("female");
//		mockArgumentCustomer.setPhoneNo("8548484884");
//		
//		Mockito.when(customerRepository.save(Mockito.any(CustomerEntity.class))).thenReturn(customerEntity);
//
//		Exception exception = assertThrows(CustomerNotFoundException.class,	() -> customerService.addCustomer(mockArgumentCustomer));
//
//		assertNotEquals("customer not added!", exception.getMessage());
//		
//	}
}
