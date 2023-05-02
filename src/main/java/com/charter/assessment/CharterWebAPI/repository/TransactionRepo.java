package com.charter.assessment.CharterWebAPI.repository;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charter.assessment.CharterWebAPI.entity.TransactionEntity;

@Repository
@Transactional
public interface TransactionRepo extends JpaRepository<TransactionEntity,Long>{
	
	
	@Query("from TransactionEntity where customerId = :customerId and transactionDate >= :from and transactionDate <= :to")
	public List<TransactionEntity> findAllByCustomerIdAndTransactionDateBetween(@Param("customerId")Long customerId, @Param("from")Date from, @Param("to")Date to);
	
	public List<TransactionEntity> findAllByCustomerId(Long customerId);
	
	public List<TransactionEntity> findAllByOrderByCustomerIdAsc();
	
	

}
