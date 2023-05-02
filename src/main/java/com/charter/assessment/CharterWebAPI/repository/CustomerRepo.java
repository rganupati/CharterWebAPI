package com.charter.assessment.CharterWebAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charter.assessment.CharterWebAPI.entity.CustomerEntity;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity,Long>{
	
	public CustomerEntity findByCustomerId(Long customerId);

}
