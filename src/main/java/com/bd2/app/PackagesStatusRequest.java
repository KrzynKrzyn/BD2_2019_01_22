package com.bd2.app;

import java.util.List;

import org.springframework.lang.NonNull;

public class PackagesStatusRequest {
	
	@NonNull
	private String new_status;
	@NonNull
	private List<Long> packages_id;
	@NonNull
	private long course_id;	
	@NonNull
	private Address address;
	@NonNull
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@NonNull
	public String getNew_status() {
		return new_status;
	}
	public void setNew_status(String new_status) {
		this.new_status = new_status;
	}
	@NonNull
	public List<Long> getPackages_id() {
		return packages_id;
	}
	
	public void setPackages_id(List<Long> packages_id) {
		this.packages_id = packages_id;
	}
	@NonNull
	public long getCourse_id() {
		return course_id;
	}
	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}


}
