package com.bd2.app;

import java.util.List;

import org.springframework.lang.NonNull;

public class OrderRequest {
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurename(String surname) {
		this.surname = surname;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<PackageRequest> getPackageList() {
		return packageList;
	}

	public void setPackageList(List<PackageRequest> packageList) {
		this.packageList = packageList;
	}

	
	public Address getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(Address sourceAddress) {
		this.sourceAddress = sourceAddress;
	}

	public Address getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(Address destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	@NonNull
	private Long customerId;
	@NonNull
	private String name;
	@NonNull
	private String surname;
	@NonNull
	private Long phoneNumber;
	@NonNull
	private Address sourceAddress;
	@NonNull
	private Address destinationAddress;
	@NonNull
	private List<PackageRequest> packageList;
	
	public static class PackageRequest {
		public Integer getWeight() {
			return weight;
		}
		public void setWeight(Integer weight) {
			this.weight = weight;
		}
		public String getType() {
			return type;
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
		public void setType(String type) {
			this.type = type;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		@NonNull
		private Integer weight;
		@NonNull
		private Double dimensionX;
		@NonNull
		private Double dimensionY;
		@NonNull
		private Double dimensionZ;
		@NonNull
		private String type;
		@NonNull
		private String description;
	}

}
