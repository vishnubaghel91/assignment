package com.bank.customerservice.dao;

import java.util.List;

import com.bank.customerservice.entity.Customer;

public interface CustomerDao {
	void save (Customer customer);
	void update (Customer customer);
	Customer get(Long customerId);
	List<Customer> getAll();
	void delete (Long customerId);
	void delete(Customer customer);
}
