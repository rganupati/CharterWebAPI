package com.charter.assessment.CharterWebAPI.model;

public class RewardsModel {

	private long customerId;
	private long totalRewards;
	private long currentMonthRewardPoints;
	private long lastMonthRewardPoints;
	private long lastSecondMonthRewardPoints;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getTotalRewards() {
		return totalRewards;
	}

	public void setTotalRewards(long totalRewards) {
		this.totalRewards = totalRewards;
	}

	public long getLastMonthRewardPoints() {
		return lastMonthRewardPoints;
	}

	public void setLastMonthRewardPoints(long lastMonthRewardPoints) {
		this.lastMonthRewardPoints = lastMonthRewardPoints;
	}

	public long getLastSecondMonthRewardPoints() {
		return lastSecondMonthRewardPoints;
	}

	public void setLastSecondMonthRewardPoints(long lastSecondMonthRewardPoints) {
		this.lastSecondMonthRewardPoints = lastSecondMonthRewardPoints;
	}

	public long getCurrentMonthRewardPoints() {
		return currentMonthRewardPoints;
	}

	public void setCurrentMonthRewardPoints(long currentMonthRewardPoints) {
		this.currentMonthRewardPoints = currentMonthRewardPoints;
	}

}
