package com.charter.assessment.CharterWebAPI.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charter.assessment.CharterWebAPI.Exception.CustomerDoNotExistsException;
import com.charter.assessment.CharterWebAPI.entity.CustomerEntity;
import com.charter.assessment.CharterWebAPI.entity.TransactionEntity;
import com.charter.assessment.CharterWebAPI.model.CustomerRewardsModel;
import com.charter.assessment.CharterWebAPI.model.RewardsModel;
import com.charter.assessment.CharterWebAPI.model.TransactionModel;
import com.charter.assessment.CharterWebAPI.repository.CustomerRepo;
import com.charter.assessment.CharterWebAPI.repository.TransactionRepo;
import com.charter.assessment.CharterWebAPI.service.RewardsService;

@Service
public class RewardsServiceImpl implements RewardsService{
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private TransactionRepo transactionRepo;

	@Override
	public List<CustomerRewardsModel> getRewards() {
		List<CustomerEntity> customers = customerRepo.findAll();
		List<CustomerRewardsModel> allCustomersRewards = new ArrayList<>();
		for(CustomerEntity customer: customers) {
			CustomerRewardsModel customerReward = new CustomerRewardsModel();
			customerReward.setCustomerId(customer.getCustomerId());
			customerReward.setCustomerName(customer.getCustomerName());
			
			List<TransactionEntity> transactionsPerCustomer = transactionRepo.findAllByCustomerId(customer.getCustomerId());
			Long rewards = processTransactionsToRewards(transactionsPerCustomer);
			customerReward.setTotalRewards(rewards);
			allCustomersRewards.add(customerReward);
		}
		return allCustomersRewards;
	}

	@Override
	public RewardsModel getRewardsByCustomerId(Long customerId) throws CustomerDoNotExistsException {
		RewardsModel responseModel = new RewardsModel();
		if(isCustomerExists(customerId)) {
			
			Long totalRewards = 0L;
			responseModel.setCustomerId(customerId);
			//Calculate for the current month
			LocalDate currentDate = LocalDate.now();
			LocalDate startDateOfMonth = currentDate.minusDays(currentDate.getDayOfMonth()-1);
		    Long rewardForCustomMonth = getRewards(customerId,startDateOfMonth,currentDate);
		    responseModel.setCurrentMonthRewardPoints(rewardForCustomMonth);
		    totalRewards = totalRewards + rewardForCustomMonth;
			
			
			//Calculate for the previous month
		    rewardForCustomMonth = 0L;
			LocalDate prevMonthEndDate = currentDate.minusDays(currentDate.getDayOfMonth());
			LocalDate prevMonthStartDate = prevMonthEndDate.minusDays(prevMonthEndDate.getDayOfMonth()-1);
		    rewardForCustomMonth = getRewards(customerId,prevMonthStartDate,prevMonthEndDate);
		    responseModel.setLastMonthRewardPoints(rewardForCustomMonth);
		    totalRewards = totalRewards + rewardForCustomMonth;
			
			//Calculate for the second previous month
		    rewardForCustomMonth = 0L;
			LocalDate secPrevMonthEndDate = prevMonthEndDate.minusDays(prevMonthEndDate.getDayOfMonth());
			LocalDate secPrevMonthStartDate = secPrevMonthEndDate.minusDays(secPrevMonthEndDate.getDayOfMonth()-1);
		    rewardForCustomMonth = getRewards(customerId,secPrevMonthStartDate,secPrevMonthEndDate);
		    responseModel.setLastSecondMonthRewardPoints(rewardForCustomMonth);
		    totalRewards = totalRewards + rewardForCustomMonth;
		    responseModel.setTotalRewards(totalRewards);
			
		}else {
			throw new CustomerDoNotExistsException("Invalid Customer Id");
		}
		return responseModel;
	}

	@Override
	public List<TransactionModel> getTransacitons() {
		List<TransactionModel> allTransactions = new ArrayList<>();
		List<TransactionEntity> transactions = transactionRepo.findAllByOrderByCustomerIdAsc();
		for(TransactionEntity transaction: transactions) {
			TransactionModel transactionModel = new TransactionModel(transaction.getCustomerId(), transaction.getTransactionDate(), transaction.getTransactionAmount());
			allTransactions.add(transactionModel);
		}
		return allTransactions;
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
	
	private Date convertToDateViaSqlDate(LocalDate dateToConvert) {
	    return java.sql.Date.valueOf(dateToConvert);
	}
	
	private Long processTransactionsToRewards(List<TransactionEntity> transactions) {
		Long rewards = 0L;
		for(TransactionEntity transaction: transactions) {
			Long amount = transaction.getTransactionAmount();
			if(amount > 100) {
				rewards = rewards+50;
				amount = amount - 100;
				rewards = rewards + (amount*2);
			}else if(amount > 50){
				amount = amount - 50;
				rewards = rewards + amount;
			}
		}
		return rewards;
	}
	
	private Long getRewards(Long customerId,LocalDate startDate, LocalDate endDate ) {
		List<TransactionEntity> transactionsForCurrentMonth = transactionRepo.findAllByCustomerIdAndTransactionDateBetween(customerId, convertToDateViaSqlDate(startDate), convertToDateViaSqlDate(endDate));
	    Long rewardForCustomMonth = processTransactionsToRewards(transactionsForCurrentMonth);
	    return rewardForCustomMonth;
	}

}
