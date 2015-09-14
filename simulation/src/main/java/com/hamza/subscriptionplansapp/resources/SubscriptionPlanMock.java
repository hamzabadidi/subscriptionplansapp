package com.hamza.subscriptionplansapp.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.hamza.subscriptionplansapp.admin.entities.plans.SubscriptionPlan;

public enum SubscriptionPlanMock {
	
	FREE("Free", 0),
	IVORY("Ivory", 9.99),
	SILVER("Silver", 19.99),
	GOLD("Gold", 29.99),
	PLATINUM("Platinum", 49.99);
	
	private String subscriptionPlanName;
	private double price;
	
	private SubscriptionPlanMock(String aName, double aPrice) {
		setSubscriptionPlanName(aName);
		setPrice(aPrice);
	}
	
	private static final List<SubscriptionPlanMock> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	public static SubscriptionPlan getARandomSubscriptionPlan()  {
		SubscriptionPlanMock randomSP = VALUES.get(RANDOM.nextInt(SIZE));
		return new SubscriptionPlan(randomSP.getSubscriptionPlanName(), randomSP.getPrice());
	}

	public String getSubscriptionPlanName() {
		return subscriptionPlanName;
	}

	public void setSubscriptionPlanName(String subscriptionPlanName) {
		this.subscriptionPlanName = subscriptionPlanName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
