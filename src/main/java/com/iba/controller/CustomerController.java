package com.iba.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iba.entity.CustomerEntity;
import com.iba.entity.UserEntity;
import com.iba.pojo.CustomerPojo;
import com.iba.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/all")
	public List<CustomerPojo> getAllCustomers() {
		return customerService.listAllCustomers();
	}
	
	@PostMapping("/create")
	public CustomerPojo createNewCustomer(@Valid @RequestBody CustomerPojo customer) {
		return customerService.addCustomer(customer);
	}

	@PostMapping("/update")
	public CustomerPojo updateNewCustomer(@Valid @RequestBody CustomerPojo customer) {
		return customerService.updateCustomer(customer);
	}
	
	@GetMapping("/{id}")
	public CustomerPojo findCustomerById(@PathVariable("id") long customerId) {
		return customerService.findCustomerById(customerId);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteCustomer(@PathVariable("id") long customerId) {
		return customerService.deleteCustomer(customerId);
	}
}
