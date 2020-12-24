package com.example.SpringProj.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Assignment {
	
	@Id
	private int empId;
	private int custId;
	private String task;
	
	public Assignment() {}
	public Assignment(int empId, int custId, String task) {
		super();
		this.empId = empId;
		this.custId = custId;
		this.task = task;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	} 
	
	
}
