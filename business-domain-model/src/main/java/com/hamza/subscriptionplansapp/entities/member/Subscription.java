package com.hamza.subscriptionplansapp.entities.member;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.hamza.subscriptionplansapp.admin.entities.plans.SubscriptionPlan;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "userName"))
public class Subscription {
	
	public Subscription(LocalDateTime aDateOfSubscription, String aUserName, String aPassword, SubscriptionPlan asubscriptionPlan) {
		dateOfSubscription = aDateOfSubscription;
		userName = aUserName;
		password = aPassword;
		subscriptionPlan = asubscriptionPlan;
	}

	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	private LocalDateTime dateOfSubscription;
	
	@NotNull
	@Size(min = 1, max = 25, message = "1-25 letters and spaces")
	private String userName;
	
	@NotNull
	private String password;
	
	@NotNull
	@OneToOne
	private SubscriptionPlan subscriptionPlan;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getDateOfSubscription() {
		return dateOfSubscription;
	}

	public void setDateOfSubscription(LocalDateTime dateOfSubscription) {
		this.dateOfSubscription = dateOfSubscription;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SubscriptionPlan getSubscriptionPlan() {
		return subscriptionPlan;
	}

	public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
		this.subscriptionPlan = subscriptionPlan;
	}

	public Subscription() {
		// For JPA
	}

}
