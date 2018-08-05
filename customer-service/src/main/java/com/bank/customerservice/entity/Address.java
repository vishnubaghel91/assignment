package com.bank.customerservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {
	
	private static final long serialVersionUID = 5081235538553049924L;
	@Column (name = "ADDRESS_LINE1")
	private String addressLine1;
	@Column (name = "ADDRESS_LINE2")
	private String addressLine2;
	@Column (name = "CITY")
	private String city;
	@Column (name = "STATE")
	private String state;
	@Column (name = "COUNTRY")
	private String country;
	@Column (name = "ZIPCODE")
	private String zipcode;
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
}
