package com.example.SpringProj.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private int empId;
	private String name;
	private String speciality;
	
	public Employee() {}
	public Employee(int empId, String name, String speciality) {
		this.empId = empId;
		this.name = name;
		this.speciality = speciality;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	@Override
	public String toString() {
		return this.empId+" "+this.name+" "+this.speciality;
	}
	
	
	
	
	
	
}
