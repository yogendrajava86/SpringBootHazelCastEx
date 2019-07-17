package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Customer;
import com.app.repo.CustomerRepository;
import com.app.service.ICustomerService;
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository repo;
	
	@Override
	@Transactional
	public Integer customerSave(Customer c) {

		return repo.save(c).getCustId();
	}

	@Override
	@Transactional(readOnly=true)
	@Cacheable(value="customer-cache",key="#custId")
	public Customer getOneCustomer(Integer custId) {
		Optional<Customer> cust=repo.findById(custId);
		if(cust.isPresent()) {
			return cust.get();
		}
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

	@Override
	@Transactional
	@CacheEvict(value="customer-cache",key="#custId")
	public void deleteCustomer(Integer custId) {
		repo.deleteById(custId);
	}

	@Override
	@Transactional
	//@CachePut(value="customer-cache",key="#custId")
	public Integer updateCustomer(Customer c,Integer custId) {
		return repo.save(c).getCustId();
	}

}
