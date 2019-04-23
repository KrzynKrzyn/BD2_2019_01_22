package com.bd2.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pojazd")
public class Vehicle {

	
	@Id
	@GeneratedValue
	@Column(name="Numer rejestracyjny")
	private String id;
	@Column(name="Typ pojazdu")
	private String type;
	@Column(name="Głębokość ładowni")
	private double depth;
	@Column(name="Szerokość ładowni")
	private double width;
	@Column(name="Wysokość ładowni")
	private double height;
	@Column(name="Maksymalne obciążenie")
	private int capacity;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getDepth() {
		return depth;
	}
	public void setDepth(double depth) {
		this.depth = depth;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}
