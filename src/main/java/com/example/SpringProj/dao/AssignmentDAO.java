package com.example.SpringProj.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface AssignmentDAO extends JpaRepository<Assignment, Integer> {

	@Transactional
	@Modifying
	@Query(value="delete from Assignment where empId = :emp and custId = :cust")
	void deleteByEmpIdAndCustId(@Param("emp") int empId, @Param("cust") int custId); //

	boolean existsByEmpId(int empId); //

	@Transactional
	@Modifying
	void deleteByEmpId(int empId); //

	@Transactional
	@Modifying
	void deleteByCustId(int custId); //

	Optional<Assignment> findByEmpId(int empId);

	boolean existsByCustId(int custId); //



	
}
