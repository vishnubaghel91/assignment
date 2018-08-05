package com.bank.customerservice.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "CUSTOMER")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 223623277741858843L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "CUSTOMER_ID")
	private Long customerId;
	
	@Column (name = "FIRST_NAME")
	private String firstName;
	
	@Column (name = "LAST_NAME")
	private String lastName;
	
	@Column (name = "EMAIL")
	private String email;
	
	@Column (name = "DATE_OF_BIRTH")
	@Temporal (TemporalType.TIMESTAMP)
	private Date dob;
	
	@Column (name = "MOBILE_NUMBER")
	private String mobile;
	
	@Column (name = "HOME_PHONE")
	private String homePhone;
	
	@Embedded
	private Address address;
	
	@OneToMany
	@JoinColumn (name = "CUSTOMER_ID")
	private Set<Account> accounts = new HashSet<>();
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
}
