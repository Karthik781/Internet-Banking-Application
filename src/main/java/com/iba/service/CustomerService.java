package com.iba.service;

import java.util.List;
import java.util.Set;

import com.iba.entity.CustomerEntity;
import com.iba.entity.UserEntity;
import com.iba.pojo.CustomerPojo;

public interface CustomerService {
	
	public CustomerPojo  addCustomer(CustomerPojo customer) ;
	public boolean deleteCustomer(long customer_id) ;
	
	public List<CustomerPojo> listAllCustomers() ;
	public CustomerPojo viewCustomerDetails(long account_id)  ;
	
	public  CustomerPojo findCustomerById(long customer_id) ;
	public CustomerPojo updateCustomer(CustomerPojo customer);
	

}
