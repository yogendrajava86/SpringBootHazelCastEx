package com.app.service;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerService {

	public Integer customerSave(Customer c);
	public Customer getOneCustomer(Integer custId);
	public List<Customer> getAllCustomers();
	public void deleteCustomer(Integer custId);
	public Integer updateCustomer(Customer c,Integer custId);
	
}
