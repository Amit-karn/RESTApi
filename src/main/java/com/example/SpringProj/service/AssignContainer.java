package com.example.SpringProj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringProj.dao.Assignment;
import com.example.SpringProj.dao.AssignmentDAO;
import com.example.SpringProj.dao.Customer;
import com.example.SpringProj.dao.Employee;



@Service
public class AssignContainer {

	@Autowired
	private EmployeeContainer employeeContainer;
	
	@Autowired
	private CustomerContainer customerContainer;

	@Autowired
	private AssignmentDAO assignmentDAO;
	
	public Result assignToAll() { //--
		List<Customer> customerList = customerContainer.findByStatus();
		if(customerList.size() == 0) {
			return new Result("No customer available");
		}
		String notFound = "";
		int flag = 0;
		for(Customer customer: customerList) {
			String req = customer.getRequirement();
			List<Employee> employeeList = employeeContainer.getBySpeciality(req);
			if(employeeList.size() == 0) {
				return new Result("No employee is available with required speciality");
			}
			if(!assignmentDAO.existsByCustId(customer.getCustId()) && 
					customerContainer.getStatus(customer.getCustId()) == 0) {
				int found = 0;
				for(Employee employee: employeeList) {
					if(!assignmentDAO.existsByEmpId(employee.getEmpId())) {
						assignmentDAO.save(new Assignment(employee.getEmpId(), customer.getCustId()
								, req));
						found = 1;
						break;
					}
				}
				if(found == 0) {
					flag = 1;
					notFound += customer.getCustId()+" - ";
				}
			}
		}
		String res = "Assigned successfully";
		return flag == 0? new Result(res+"!") : new Result(res+" except for custId = "+notFound);
		
	}
	
	public Result assignToEmpId( int empId, int custId) { //
		Employee employee = employeeContainer.getByEmpId(empId);
		Customer customer = customerContainer.getByCustId(custId);
		
		if(!(employee.getSpeciality().equals(customer.getRequirement()))) {
			return new Result("Employee doesn\'t have a specialization for the customer requirement");
		}
		else if(assignmentDAO.existsByEmpId(empId)) {
			return new Result("Employee already Occupied");
		}
		assignmentDAO.save(new Assignment(empId, custId, customer.getRequirement()));
		return new Result("Successfully Assigned!");
	}
	public List<Assignment> assigned() { //
		List<Assignment> list = new ArrayList<>();
		assignmentDAO.findAll().forEach(list::add);
		return list;
	}

	public Assignment assignedToEmployeeId(int empId) { //
		return assignmentDAO.findByEmpId(empId).orElse(null);
	}

	public Result delete(int empId, int custId) { //
		if(assignmentDAO.existsByEmpId(empId) && assignmentDAO.existsByCustId(custId)) {
			assignmentDAO.deleteByEmpIdAndCustId(empId, custId);
			customerContainer.updateStatusForCustId(custId);
			return new Result("Successfully deleted the assignment!");
		}
		return new Result("No assignment exists with this EmpId and CustId.");
	}
	
	public void deleteByEmpId(int empId) {//
		assignmentDAO.deleteByEmpId(empId);
	}

	public void deleteByCustId(int custId) { //
		assignmentDAO.deleteByCustId(custId);
	}
	
	
	
}
