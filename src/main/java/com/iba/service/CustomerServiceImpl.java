package com.iba.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iba.entity.CustomerEntity;
import com.iba.entity.UserEntity;
import com.iba.exception.BeneficiaryNotFoundException;
import com.iba.exception.CustomerNotFoundException;
import com.iba.pojo.CustomerPojo;
import com.iba.pojo.UserPojo;
import com.iba.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public CustomerPojo addCustomer(CustomerPojo customer) {

		CustomerEntity entity = new CustomerEntity();

		BeanUtils.copyProperties(customer, entity);

		CustomerEntity newEntity = customerRepository.save(entity);

		if (newEntity.equals(null) == true) {
			throw new CustomerNotFoundException("customer not added!");
		}

		BeanUtils.copyProperties(newEntity, customer);

		return customer;
	}

	@Override
	public CustomerPojo updateCustomer(CustomerPojo customer) {
		CustomerEntity entity = new CustomerEntity();

		BeanUtils.copyProperties(customer, entity);

		CustomerEntity newEntity = customerRepository.save(entity);

		BeanUtils.copyProperties(newEntity, customer);

		return customer;
	}

	@Override
	public boolean deleteCustomer(long customer_id) {
		customerRepository.deleteById(customer_id);
		return true;
	}

	@Override
	public List<CustomerPojo> listAllCustomers() {

		List<CustomerEntity> cutomer = customerRepository.findAll();

		if (cutomer.isEmpty()) {
			throw new CustomerNotFoundException("No cutomer  found");
		}

		List<CustomerPojo> userPojos = new ArrayList<CustomerPojo>();

		for (UserEntity entity : cutomer) {
			CustomerPojo cp = new CustomerPojo();

			BeanUtils.copyProperties(entity, cp);

			userPojos.add(cp);

		}

		return userPojos;

	}

	@Override
	public CustomerPojo viewCustomerDetails(long account_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerPojo findCustomerById(long customerId) {

		Optional<CustomerEntity> entity = customerRepository.findById(customerId);

		if (entity.isPresent() == false) {
			throw new CustomerNotFoundException("Customer with id not found");
		}

		CustomerPojo pojo = new CustomerPojo();

		BeanUtils.copyProperties(entity.get(), pojo);

		return pojo;

	}

}
