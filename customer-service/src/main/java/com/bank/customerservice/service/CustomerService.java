package com.bank.customerservice.service;

import java.util.List;

import com.bank.customerservice.request.CustomerRQ;
import com.bank.customerservice.response.CustomerRS;

public interface CustomerService {
	
	CustomerRS createCustomer (CustomerRQ customerRQ);
	CustomerRS get(Long customerId);
	List<CustomerRS> getAll();
	void deleteCustomer(Long customerId);
	void update(Long customerId, CustomerRQ customerRQ);

}