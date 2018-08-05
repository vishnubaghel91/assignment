package com.bank.customerservice.request;

import java.io.Serializable;
import java.util.Date;

import com.bank.customerservice.entity.Address;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude (content = Include.NON_NULL)
public class CustomerRQ implements Serializable {

	private static final long serialVersionUID = 8025897562101669265L;
	
	private String firstName;
	private String lastName;
	private String email;
	@JsonFormat (shape  = Shape.STRING, pattern = "MM/dd/yyyy")
	private Date dob;
	private String mobile;
	private String homePhone;
	private AddressRQ address;
	
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
	public AddressRQ getAddress() {
		return address;
	}
	public void setAddress(AddressRQ address) {
		this.address = address;
	}
	
}
