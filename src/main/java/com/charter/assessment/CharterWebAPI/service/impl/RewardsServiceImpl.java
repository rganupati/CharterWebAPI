package com.charter.assessment.CharterWebAPI.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charter.assessment.CharterWebAPI.Exception.CustomerDoNotExistsException;
import com.charter.assessment.CharterWebAPI.entity.CustomerEntity;
import com.charter.assessment.CharterWebAPI.model.RewardsModel;
import com.charter.assessment.CharterWebAPI.model.TransactionModel;
import com.charter.assessment.CharterWebAPI.repository.CustomerRepo;
import com.charter.assessment.CharterWebAPI.service.RewardsService;

@Service
public class RewardsServiceImpl implements RewardsService{
	
	@Autowired
	CustomerRepo customerRepo;

	@Override
	public List<RewardsModel> getRewards() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RewardsModel getRewardsByCustomerId(Long customerId) throws CustomerDoNotExistsException {
		if(isCustomerExists(customerId)) {
			
		}else {
			//throw new Customer does not Exists exception
			throw new CustomerDoNotExistsException("Invalid Customer Id");
		}
		return null;
	}

	@Override
	public List<TransactionModel> getTransacitons() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean isCustomerExists(Long customerId) {
		Optional<CustomerEntity> customer = customerRepo.findById(customerId);
		if(customer.isPresent()) {
			return true;
		}
		else {
			return false;
		}
	}

}
