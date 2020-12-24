package com.example.SpringProj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringProj.dao.Assignment;
import com.example.SpringProj.dao.Customer;
import com.example.SpringProj.dao.Employee;
import com.example.SpringProj.service.AssignContainer;
import com.example.SpringProj.service.CustomerContainer;
import com.example.SpringProj.service.EmployeeContainer;
import com.example.SpringProj.service.Result;

@RestController
public class Controller {
	
	@Autowired
	private EmployeeContainer employeeContainer;
	@Autowired
	private CustomerContainer customerContainer;
	@Autowired
	private AssignContainer assignContainer;
	
	//Employee request
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeContainer.get();
	}
	
	@GetMapping("/employees/{empId}")
	public Employee getByEmpId(@PathVariable int empId) {
		return employeeContainer.getByEmpId(empId);
	}
	
	@PostMapping("/employees")
	public Result addEmployee(@RequestBody Employee employee) {
		return employeeContainer.add(employee);
	}
	
	@PutMapping("/employees/{empId}")
	public Result updateEmployee(@RequestBody Employee employee,@PathVariable int empId) {
		return employeeContainer.update(employee, empId);
	}
	
	@DeleteMapping("/employees/{empId}")
	public Result deleteByEmpId(@PathVariable int empId) {
		return employeeContainer.deleteByEmpId(empId);
	}
	
	//Customer request
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerContainer.get();
	}

	@GetMapping("/customers/{custId}")
	public Customer getByCustId(@PathVariable int custId) {
		return customerContainer.getByCustId(custId);
	}
	
	@PostMapping("/customers")
	public Result addCustomer(@RequestBody Customer customer) {
		 return customerContainer.add(customer);
	}
	
	@PutMapping("/customers/{custId}") 
	public Result updateCustomer(@RequestBody Customer customer,@PathVariable int custId) {
		return customerContainer.update(customer, custId);
	}
	
	@DeleteMapping("/customers/{custId}")
	public Result deleteByCustId(@PathVariable int custId) {
		return customerContainer.deleteByCustId(custId);
	}
	//assignment
	
	/*assignToAll
	assignByID
	assigned
	assignedToEmployeeId
	assignedForCustomerId
	*/
	@PutMapping("/assign")
	public Result assignToAll() {
		return assignContainer.assignToAll();
	}
	
	@GetMapping("/assign")
	public List<Assignment> assigned() {
		return assignContainer.assigned();
	}
	
	@GetMapping("/assign/{id}")
	public Assignment assignedToEmployeeId(@PathVariable int id) {
		return assignContainer.assignedToEmployeeId(id);
	}
	
	@DeleteMapping("/assign/{empId}/{custId}")
	public Result delete(@PathVariable int empId, @PathVariable int custId) {
		return assignContainer.delete(empId, custId);
	}
	
	@PutMapping("/assign/{empId}/{custId}")
	public Result assignToEmpId( @PathVariable int empId, @PathVariable int custId) {
		return assignContainer.assignToEmpId(empId, custId);
	}
	
}
