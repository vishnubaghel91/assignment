package com.bank.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.customerservice.request.CustomerRQ;
import com.bank.customerservice.response.CustomerRS;
import com.bank.customerservice.service.CustomerService;

@RestController
@RequestMapping (path = "/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	/*
	 * This Api is for create the customer
	 */
	@PostMapping (path = "/")
	public ResponseEntity<CustomerRS> create (@RequestBody CustomerRQ customerRQ) {
		CustomerRS customerRS = customerService.createCustomer(customerRQ);
		return ResponseEntity.status(HttpStatus.CREATED).body(customerRS);
	}	

	/*
	 * this Api is for get customer by ID
	 */
	@GetMapping (path = "/{customerId}")
	public ResponseEntity<CustomerRS> getCustomerById (@PathVariable (value = "customerId") Long customerId) {
		CustomerRS customerRS = customerService.get(customerId);
		return ResponseEntity.status(HttpStatus.OK).body(customerRS);
	}
	
	/*
	 * this api is for getting list of customers
	 */
	@GetMapping (path = "/")
	public ResponseEntity<List<CustomerRS>> getCustomers () {
		List<CustomerRS> customers = customerService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(customers);
	}
	
	/*
	 * this api is for deleting customers by id
	 */
	
	@DeleteMapping (path = "/{customerId}")
	public ResponseEntity<String> delete (@PathVariable (value = "customerId") Long customerId) {
		customerService.deleteCustomer(customerId);
		return ResponseEntity.status(HttpStatus.OK).body("success");
	}
	
	
	/*
	 * this api is updating customers by id
	 */
	
	@PutMapping (path = "/{customerId}")
	public ResponseEntity<String> update (@PathVariable (value = "customerId") Long customerId, @RequestBody CustomerRQ customerRQ) {
		customerService.update(customerId, customerRQ);
		return ResponseEntity.status(HttpStatus.OK).body("success");
	}
	
}
