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
import org.springframework.boot.test.context.SpringBootTest;

import com.iba.entity.AccountEntity;
import com.iba.entity.CustomerEntity;
import com.iba.exception.CustomerNotFoundException;
import com.iba.pojo.CustomerPojo;
import com.iba.repository.CustomerRepository;
import com.iba.service.CustomerService;
import com.iba.service.CustomerServiceImpl;

@SpringBootTest
public class CustomerServiceTest {
	
	@InjectMocks
	CustomerService customerService = new CustomerServiceImpl();
	
	@Mock
	CustomerRepository customerRepository;
	
	@Test
	public void testGetAllCustomers() {
		
		List<CustomerEntity> mockCustomers = new ArrayList<CustomerEntity>();
		
		mockCustomers.add(new CustomerEntity("gvw124","cust", "maria", "567567", "maria@mail.com", 20, "female", null));
		mockCustomers.add(new CustomerEntity("gvw124","cust", "tom", "98989569", "karth@mail.com", 23, "male", null));
		mockCustomers.add(new CustomerEntity("gvw124","cust", "kedam", "89457845", "kedam@mail.com", 20, "male", null));
		
		Mockito.when(customerRepository.findAll()).thenReturn(mockCustomers);
		
		assertEquals(3, customerService.listAllCustomers().size());
	}
	
	@Test
	public void testAddCustomer() {
		
		CustomerPojo mockArgumentCustomer = new CustomerPojo();
		mockArgumentCustomer.setAge(20);
		mockArgumentCustomer.setCustomerName("maria");
		mockArgumentCustomer.setEmailId("maria@mail.com");
		mockArgumentCustomer.setGender("female");
		mockArgumentCustomer.setPhoneNo("8548484884");
		
		
		CustomerEntity mockEntity = new CustomerEntity();
		mockEntity.setCustomerId(101);
		mockEntity.setAge(20);
		mockEntity.setCustomerName("maria");
		mockEntity.setEmailId("maria@mail.com");
		mockEntity.setGender("female");
		mockEntity.setPhoneNo("8548484884");
		
		
		BeanUtils.copyProperties(mockArgumentCustomer, mockEntity);
		
		Mockito.when(customerRepository.save(Mockito.any(CustomerEntity.class))).thenReturn(mockEntity);
		
		assertEquals("maria", customerService.addCustomer(mockArgumentCustomer).getCustomerName());
	}
	

	
	@Test
	public void testfindCustomerByIdException() {
		Optional<CustomerEntity> courseEntity = Optional.empty();
		
		CustomerPojo mockArgumentCustomer = new CustomerPojo();
		mockArgumentCustomer.setAge(20);
		mockArgumentCustomer.setCustomerName("maria");
		mockArgumentCustomer.setEmailId("maria@mail.com");
		mockArgumentCustomer.setGender("female");
		mockArgumentCustomer.setPhoneNo("8548484884");
		
		Mockito.when(customerRepository.findById(Mockito.anyLong())).thenReturn(courseEntity);

		Exception exception = assertThrows(CustomerNotFoundException.class,	() -> customerService.findCustomerById(20));

		assertEquals("Customer with id not found", exception.getMessage());
		
	}
	
	@Test
	public void testAddCustomerException() {
		CustomerEntity customerEntity = null;
		
		CustomerPojo mockArgumentCustomer = new CustomerPojo();
		mockArgumentCustomer.setAge(20);
		mockArgumentCustomer.setCustomerName("maria");
		mockArgumentCustomer.setEmailId("maria@mail.com");
		mockArgumentCustomer.setGender("female");
		mockArgumentCustomer.setPhoneNo("8548484884");
		
		Mockito.when(customerRepository.save(Mockito.any(CustomerEntity.class))).thenReturn(customerEntity);

		Exception exception = assertThrows(CustomerNotFoundException.class,	() -> customerService.addCustomer(mockArgumentCustomer));

		assertNotEquals("customer not added!", exception.getMessage());
		
	}

}
