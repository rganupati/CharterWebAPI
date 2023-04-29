package com.charter.assessment.CharterWebAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charter.assessment.CharterWebAPI.entity.CustomerEntity;

@Repository
public interface CustomerRepo extends CrudRepository<CustomerEntity,Long>{

}
