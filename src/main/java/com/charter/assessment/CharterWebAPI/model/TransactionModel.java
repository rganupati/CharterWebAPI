package com.charter.assessment.CharterWebAPI.model;

import java.sql.Date;

public class TransactionModel {

	private Long customerId;
	private Date transactionDate;
	private Long transactionAmount;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Long getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public TransactionModel(Long customerId, Date transactionDate, Long transactionAmount) {
		this.setCustomerId(customerId);
		this.setTransactionDate(transactionDate);
		this.setTransactionAmount(transactionAmount);
	}
	
}
