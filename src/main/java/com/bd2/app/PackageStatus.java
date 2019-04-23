package com.bd2.app;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Zmiana statusu paczki")
public class PackageStatus {
	@Id
	@GeneratedValue
	@Column(name="Identyfikator")
	private long id;
	@Column(name="Status paczki")
	private String new_status;
	@Column(name="Paczka")
	private long package_id;
	@Column(name="Kurs")
	private long course_id;
	@Column(name="Data zmiany")
	private Date date;	
	@Column(name="Adres wystąpienia zmiany")
	private long address_id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNew_status() {
		return new_status;
	}
	public void setNew_status(String new_status) {
		this.new_status = new_status;
	}
	public long getPackage_id() {
		return package_id;
	}
	public void setPackage_id(long package_id) {
		this.package_id = package_id;
	}
	public long getCourse_id() {
		return course_id;
	}
	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getAddress_id() {
		return address_id;
	}
	public void setAddress_id(long address_id) {
		this.address_id = address_id;
	}
	
}
