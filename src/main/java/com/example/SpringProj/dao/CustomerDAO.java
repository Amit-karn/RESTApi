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
public interface CustomerDAO extends JpaRepository<Customer, Integer>{

	Optional<Customer> findByCustId(int custId);//

	@Transactional
	@Modifying
	void deleteByCustId(int custId);//

	@Transactional
	@Modifying
	@Query(value="update Customer c set c.status=:status where c.custId=:cust")
	void updateStatusForCustId(@Param("cust") int custId, @Param("status") int status); //

	@Query(value="select status from Customer c where c.custId=:cust")
	int findStatus(@Param("cust") int custId); //

	boolean existsByCustId(int custId); //

	List<Customer> findAllByStatus(int i);



}
