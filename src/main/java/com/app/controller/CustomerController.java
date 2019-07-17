package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.Customer;
import com.app.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService service;
	
	//1. show customer register page with form backing object
	@RequestMapping("/reg")
	public String showReg(Model map) {
		map.addAttribute("customer",new Customer());
		return "Register";
	}
	
	//2. Save Customer data into DB
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveData(@ModelAttribute Customer customer, Model map) {
		
		Integer id=service.customerSave(customer);
		map.addAttribute("customer",new Customer());
		map.addAttribute("message","Customer '"+id+"' created!!");
		return "Register";
	}
	
	//3. show Customer List
	@RequestMapping("/all")
	public String showAll(Model map) {
		List<Customer> cuslist=service.getAllCustomers();
		map.addAttribute("list",cuslist);
		
		return "All";
	}
	
	//4. show view one customer
	@RequestMapping("/view/{id}")
	public String showCustomerView(@PathVariable Integer id,Model map) {
		
		Customer cust=service.getOneCustomer(id);
		map.addAttribute("customerdt",cust);
		return "View";
	}
	
	//5. delete customer
	@RequestMapping("/delete/{id}")
	public String deleteCust(@PathVariable Integer id, Model map) {
		service.deleteCustomer(id);
		map.addAttribute("message","Customer '"+id+"' deleted !!");
		return "redirect:/customer/all";
	}
	
	//6. edit customer
	@RequestMapping("/edit/{id}")
	public String editCustomer(@PathVariable Integer id, Model map) {
		Customer custm=service.getOneCustomer(id);
		map.addAttribute("customer",custm);
		map.addAttribute("MODE","EDIT");
		return "Register";
	}
	
	//7. update Customer data into DB
	@RequestMapping(value="/update",method=RequestMethod.POST)
		public String saveUpdateData(@ModelAttribute Customer customer, Model map) {
		Integer id=customer.getCustId();
		Integer custId=service.updateCustomer(customer,id);
			
			map.addAttribute("customer",new Customer());
			map.addAttribute("message","Customer '"+custId+"' Updated!!");
			return "redirect:all";
		}
	
}
