package com.charter.assessment.CharterWebAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charter.assessment.CharterWebAPI.entity.TransactionEntity;

@Repository
@Transactional
public interface TransactionRepo extends CrudRepository<TransactionEntity,Long>{

}
