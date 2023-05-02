package com.charter.assessment.CharterWebAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charter.assessment.CharterWebAPI.Exception.CustomerDoNotExistsException;
import com.charter.assessment.CharterWebAPI.model.CustomerRewardsModel;
import com.charter.assessment.CharterWebAPI.model.RewardsModel;
import com.charter.assessment.CharterWebAPI.model.TransactionModel;
import com.charter.assessment.CharterWebAPI.service.RewardsService;

@RestController
@RequestMapping(path = "/chartercom")
public class RewardsController {

	@Autowired
	RewardsService rewardsService;

	@GetMapping(value = "/rewards", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CustomerRewardsModel>> getRewards() {

		try {
			List<CustomerRewardsModel> allCustomerRewards = rewardsService.getRewards();
			return new ResponseEntity<>(allCustomerRewards, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * 
	 * @param customerId
	 * @return
	 */
	@GetMapping(value = "/rewards/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getRewardsByCustomerId(@PathVariable("customerId") Long customerId) {

		try {
			RewardsModel customerRewards = rewardsService.getRewardsByCustomerId(customerId);
			return new ResponseEntity<>(customerRewards, HttpStatus.OK);
		} catch (CustomerDoNotExistsException cust) {
			return new ResponseEntity<>(cust.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(value = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getTransactions() {

		try {
			List<TransactionModel> allTransactions = rewardsService.getTransacitons();
			return new ResponseEntity<>(allTransactions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
