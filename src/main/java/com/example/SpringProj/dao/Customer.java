package com.example.SpringProj.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private int custId;
	private String name;
	private String requirement;
	private int status=0;
	
	public Customer() {}
	public Customer(int custId, String name, String requirement) {
		super();
		this.custId = custId;
		this.name = name;
		this.requirement = requirement;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
