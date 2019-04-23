package com.bd2.app;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Klient")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name="Identyfikator")
	private long id;
	@Column(name="Adres")
	private long addressId;
	@Column(name="Telefon")
	private long phoneNumber;
	@Column(name="E-mail")
	private String email;
	@Column(name="Data rozpoczęcia współpracy")
	private Date startDate;
	@Column(name="Typ klienta")
	private String customerType;
	@Column(name="Imię")
	private String name;
	@Column(name="Nazwisko")
	private String surename;
	@Column(name="Nazwa firmy")
	private String companyName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurename() {
		return surename;
	}
	public void setSurename(String surename) {
		this.surename = surename;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
