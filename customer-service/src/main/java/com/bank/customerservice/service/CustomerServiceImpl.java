package com.bank.customerservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.customerservice.dao.CustomerDao;
import com.bank.customerservice.entity.Address;
import com.bank.customerservice.entity.Customer;
import com.bank.customerservice.exceptions.RestException;
import com.bank.customerservice.request.CustomerRQ;
import com.bank.customerservice.response.AddressRS;
import com.bank.customerservice.response.CustomerRS;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public CustomerRS createCustomer(CustomerRQ customerRQ) {
		//convert request object to entity object
		Customer customer = new Customer();
		Address address = new Address();
		
		BeanUtils.copyProperties(customerRQ, customer);
		BeanUtils.copyProperties(customerRQ.getAddress(), address);
		customer.setAddress(address);
		//save entity
		customerDao.save(customer);
		
		//convert entity object to response object
		CustomerRS customerRS = new CustomerRS();
		AddressRS addressRS = new AddressRS();
		BeanUtils.copyProperties(customer, customerRS);
		BeanUtils.copyProperties(customer.getAddress(), addressRS);
		customerRS.setAddress(addressRS);
		return customerRS;
		
	}

	@Override
	public CustomerRS get(Long customerId) {
		Customer customer = customerDao.get(customerId);
		CustomerRS customerRS = new CustomerRS();
		AddressRS addressRS = new AddressRS();
		BeanUtils.copyProperties(customer, customerRS);
		BeanUtils.copyProperties(customer.getAddress(), addressRS);
		customerRS.setAddress(addressRS);
		return customerRS;
	}

	@Override
	public List<CustomerRS> getAll() {
		List<CustomerRS> customerRSs = new ArrayList<>();
		List<Customer> customers = customerDao.getAll();
		for (Customer customer : customers) {
			CustomerRS customerRS = new CustomerRS();
			AddressRS addressRS = new AddressRS();
			BeanUtils.copyProperties(customer, customerRS);
			if (customer.getAddress() != null) {
				BeanUtils.copyProperties(customer.getAddress(), addressRS);
			}
			customerRS.setAddress(addressRS);
			customerRSs.add(customerRS);
		}
		return customerRSs;
	}

	@Override
	public void deleteCustomer(Long customerId) {
		customerDao.delete(customerId);
	}

	@Override
	public void update(Long customerId, CustomerRQ customerRQ) {
		Customer customer = customerDao.get(customerId);
		if (customer == null) {
			throw new RestException("Customer Id doesn't exists");
		}
		//convert request object to entity object
		Address address = new Address();
		BeanUtils.copyProperties(customerRQ, customer);
		BeanUtils.copyProperties(customerRQ.getAddress(), address);
		customer.setAddress(address);
		customerDao.update(customer);
	}

}
