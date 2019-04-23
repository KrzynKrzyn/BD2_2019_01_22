package com.bd2.app;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Kurs")
public class Course {

	@Id
	@GeneratedValue
	@Column(name="Identyfikator")
	private long id;
	@Column(name="Kierowca")
	private long driver;
	@Column(name="Pojazd")
	private String vehicle;
	@Column(name="Data planowanego rozpoczęcia")
	private Date planned_start;
	@Column(name="Data planowanego zakończenia")
	private Date planned_end;
	@Column(name="Data faktycznego rozpoczęcia")
	private Date real_start;
	@Column(name="Data faktycznego zakończenia")
	private Date real_end;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getDriver() {
		return driver;
	}
	public void setDriver(long driver) {
		this.driver = driver;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public Date getPlanned_start() {
		return planned_start;
	}
	public void setPlanned_start(Date planned_start) {
		this.planned_start = planned_start;
	}
	public Date getPlanned_end() {
		return planned_end;
	}
	public void setPlanned_end(Date planned_end) {
		this.planned_end = planned_end;
	}
	public Date getReal_start() {
		return real_start;
	}
	public void setReal_start(Date real_start) {
		this.real_start = real_start;
	}
	public Date getReal_end() {
		return real_end;
	}
	public void setReal_end(Date real_end) {
		this.real_end = real_end;
	}
	
}
