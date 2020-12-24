package com.example.SpringProj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringProj.dao.Customer;
import com.example.SpringProj.dao.CustomerDAO;

@Service
public class CustomerContainer {

	@Autowired
	private CustomerDAO custDAO; 
	
	@Autowired
	private AssignContainer assignContainer;
	
	
	
	public List<Customer> get() { //
		List<Customer> list = new ArrayList<>();
		custDAO.findAll().forEach(list::add);
		return list;
	}

	public Customer getByCustId(int custId) { //
		 return custDAO.findByCustId(custId).orElse(null);
	}

	public Result add(Customer customer) { //
		custDAO.save(customer);
		return new Result("Customer Added Successfully!");
	}

	public Result update(Customer customer, int custId) {//
		custDAO.save(customer);
		assignContainer.deleteByCustId(custId);
		return new Result("Customer Updated Successfully!");
	}

	public Result deleteByCustId(int custId) { //
		if(custDAO.existsByCustId(custId)) {
			custDAO.deleteByCustId(custId);
			assignContainer.deleteByCustId(custId);
			return new Result("Customer Deleted Successfully!");
		}
		return new Result("CustId doesn't exists.");
	}

	public void updateStatusForCustId(int custId) { //
		custDAO.updateStatusForCustId(custId, 1);
		
	}

	public Integer getStatus(int custId) {
		return custDAO.findStatus(custId);
	}

	public List<Customer> findByStatus() {
		return custDAO.findAllByStatus(0);
	}

	
	
	



}
