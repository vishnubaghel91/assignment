package com.bank.customerservice.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.customerservice.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void save(Customer customer) {
		entityManager.persist(customer);
	}

	@Override
	public void update(Customer customer) {
		entityManager.merge(customer);
	}

	@Override
	public Customer get(Long customerId) {
		return entityManager.find(Customer.class, customerId);
	}

	@Override
	public void delete(Long customerId) {
		Customer customer = get(customerId);
		entityManager.remove(customer);
	}
	
	@Override
	public void delete(Customer customer) {
		entityManager.remove(customer);
	}

	@Override
	public List<Customer> getAll() {
		List<Customer> customers = entityManager.createQuery("from Customer").getResultList();
		return customers;
	}

}
