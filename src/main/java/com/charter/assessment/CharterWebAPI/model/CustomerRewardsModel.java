package com.charter.assessment.CharterWebAPI.model;

public class CustomerRewardsModel {

	private Long customerId;
	private String customerName;
	private Long totalRewards;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getTotalRewards() {
		return totalRewards;
	}

	public void setTotalRewards(Long totalRewards) {
		this.totalRewards = totalRewards;
	}

}
