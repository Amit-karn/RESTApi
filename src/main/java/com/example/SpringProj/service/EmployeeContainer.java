package com.example.SpringProj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringProj.dao.Employee;
import com.example.SpringProj.dao.EmployeeDAO;

@Service
public class EmployeeContainer {
	
	@Autowired
	private EmployeeDAO empDAO;
	
	@Autowired
	private AssignContainer assignContainer;
	
	
	public Result add(Employee employee) { //
		empDAO.save(employee);
		return new Result("Employee added successfully!");
	}

	public List<Employee> get() {//
		List<Employee> list = new ArrayList<>();
		empDAO.findAll().forEach(list::add);
		return list;
	}
	public Employee getByEmpId(int empId) {//
		return empDAO.findByEmpId(empId).orElse(null);
	}

	public Result update(Employee employee, int empId) {  //
		empDAO.save(employee);	
		return new Result("Employee Updated successfully!");	
	}

	public Result deleteByEmpId(int empId) { //
		if(empDAO.existsByEmpId(empId)) {
			empDAO.deleteByEmpId(empId);
			assignContainer.deleteByEmpId(empId);
			return new Result("Employee Deleted successfully!");
		}
		return new Result("EmpId doesn't exists");
	}
	
	public List<Employee> getBySpeciality(String speciality) { //
		return empDAO.findBySpecialityOrderByEmpId(speciality);
	}

	
	
	
	
	
}
