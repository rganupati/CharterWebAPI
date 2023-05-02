package com.charter.assessment.CharterWebAPI.service;

import java.util.List;

import com.charter.assessment.CharterWebAPI.Exception.CustomerDoNotExistsException;
import com.charter.assessment.CharterWebAPI.model.CustomerRewardsModel;
import com.charter.assessment.CharterWebAPI.model.RewardsModel;
import com.charter.assessment.CharterWebAPI.model.TransactionModel;

/**
 * Rewards Service Interface that highlights the services that are offered in the rewards calculation flow.
 * @author rajesh
 *
 */
public interface RewardsService {
	
	public List<CustomerRewardsModel> getRewards();
	
	public RewardsModel getRewardsByCustomerId(Long customerId) throws CustomerDoNotExistsException;
	
	public List<TransactionModel> getTransacitons();

}
