package com.bank.customerservice;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Incubating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bank.customerservice.dao.CustomerDao;
import com.bank.customerservice.entity.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class CustomerServiceApplicationTests {
	
	
	@Autowired 
	private CustomerDao customerDao;

	@Test
	@Transactional
	@Ignore
	public void createCustomer() {
		Customer customer = new Customer(); 
		customer.setDob(new Date());
		customer.setEmail("vishnu");
		customerDao.save(customer);
		assertNotNull(customer.getCustomerId());
	}
	
	@Test
	//@Rollback (value = false)
	@Ignore
	@Transactional
	public void update() {
		Customer customer = customerDao.get(2L);
		String emailOld = customer.getEmail();
		customer.setEmail("tyerw@hkshj.com");
		customerDao.update(customer);
		assertNotEquals(emailOld, customer.getEmail());
	}
	
	@Test
	//@Rollback (value = false)
	@Transactional
	public void deleteCustomer() {
		Customer customer = customerDao.get(2L);
		customerDao.delete(customer);
		Customer customer2 = customerDao.get(2L);
		assertNull(customer2);
	}

}
