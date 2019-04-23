package com.bd2.app;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Zlecenie")
public class Order {
	@Id
	@GeneratedValue
	@Column(name="Identyfikator")
	private Long id;
	@Column(name="Klient")
	private Long customerId;
	@Column(name="Data złożenia")
	private Date date;
	@Column(name="Adres odbioru")
	private Long sourceAddressId;
	@Column(name="Adres dostarczenia")
	private Long destinationAddressId;
	@Column(name="Imię osoby kontaktowej")
	private String representativeName;
	@Column(name="Nazwisko osoby kontaktowej")
	private String representativeSurname;
	@Column(name="Telefon osoby kontaktowej")
	private Long representativePhoneNumber;
	@Column(name="Data planowanego odbioru")
	private Date expectedPickupDate;
	@Column(name="Data planowanego dostarczenia")
	private Date expectedDeliveryDate;
	@Column(name="Data faktycznego odbioru")
	private Date realPickupDate;
	@Column(name="Data faktycznego dostarczenia")
	private Date realDeliveryDate;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getSourceAddressId() {
		return sourceAddressId;
	}
	public void setSourceAddressId(Long sourceAddressId) {
		this.sourceAddressId = sourceAddressId;
	}
	public Long getDestinationAddressId() {
		return destinationAddressId;
	}
	public void setDestinationAddressId(Long destinationAddressId) {
		this.destinationAddressId = destinationAddressId;
	}
	public String getRepresentativeName() {
		return representativeName;
	}
	public void setRepresentativeName(String representativeName) {
		this.representativeName = representativeName;
	}
	public String getRepresentativeSurname() {
		return representativeSurname;
	}
	public void setRepresentativeSurname(String representativeSurname) {
		this.representativeSurname = representativeSurname;
	}
	public Long getRepresentativePhoneNumber() {
		return representativePhoneNumber;
	}
	public void setRepresentativePhoneNumber(Long representativePhoneNumber) {
		this.representativePhoneNumber = representativePhoneNumber;
	}
	public Date getExpectedPickupDate() {
		return expectedPickupDate;
	}
	public void setExpectedPickupDate(Date expectedPickupDate) {
		this.expectedPickupDate = expectedPickupDate;
	}
	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}
	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}
	public Date getRealPickupDate() {
		return realPickupDate;
	}
	public void setRealPickupDate(Date realPickupDate) {
		this.realPickupDate = realPickupDate;
	}
	public Date getRealDeliveryDate() {
		return realDeliveryDate;
	}
	public void setRealDeliveryDate(Date realDeliveryDate) {
		this.realDeliveryDate = realDeliveryDate;
	}
	public Long getId() {
		return id;
	}
	
}
