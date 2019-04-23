package com.bd2.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Paczka")
public class Package {
	@Id
	@GeneratedValue
	@Column(name="Identyfikator")
	private Long id;
	@Column(name="Zlecenie")
	private Long orderId;
	@Column(name="Zawartość")
	private Long contentId;
	@Column(name="Status")
	private String status;
	@Column(name="Waga")
	private Integer weight;
	@Column(name="Wymiar X")
	private Double dimensionX;
	@Column(name="Wymiar Y")
	private Double dimensionY;
	@Column(name="Wymiar Z")
	private Double dimensionZ;
	public Long getId() {
		return id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getContentId() {
		return contentId;
	}
	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Double getDimensionX() {
		return dimensionX;
	}
	public void setDimensionX(Double dimensionX) {
		this.dimensionX = dimensionX;
	}
	public Double getDimensionY() {
		return dimensionY;
	}
	public void setDimensionY(Double dimensionY) {
		this.dimensionY = dimensionY;
	}
	public Double getDimensionZ() {
		return dimensionZ;
	}
	public void setDimensionZ(Double dimensionZ) {
		this.dimensionZ = dimensionZ;
	}
}
