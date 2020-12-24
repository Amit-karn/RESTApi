package com.example.SpringProj.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeDAO extends JpaRepository<Employee, Integer>{

	@Query(value="from Employee e where e.speciality=:spec order by e.empId")
	List<Employee> findBySpecialityOrderByEmpId(@Param("spec") String speciality); //

	Optional<Employee> findByEmpId(int empId); //

	@Transactional
	@Modifying
	void deleteByEmpId(int empId); //

	boolean existsByEmpId(int empId); //


}
