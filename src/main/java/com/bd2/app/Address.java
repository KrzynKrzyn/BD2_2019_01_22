package com.bd2.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="Adres")
public class Address {
	public long getId() {
		return id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBuildingNumber() {
		return buildingNumber;
	}
	public void setBuildingNumber(String building_number) {
		this.buildingNumber = building_number;
	}
	@Id
	@GeneratedValue
	@Column(name="Identyfikator")
	private long id;
	@NonNull
	@Column(name="Miasto")
	private String city;
	@NonNull
	@Column(name="Ulica")
	private String street;
	@NonNull
	@Column(name="Numer budynku")
	private String buildingNumber;
}