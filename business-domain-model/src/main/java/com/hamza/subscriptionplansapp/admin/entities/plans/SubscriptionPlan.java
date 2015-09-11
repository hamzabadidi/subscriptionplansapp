package com.hamza.subscriptionplansapp.admin.entities.plans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({@NamedQuery(name = "findAllSubscriptionPlans", query = "SELECT sp FROM SubscriptionPlan sp"),
			   @NamedQuery(name = "findSubscriptionPlanNamed", query = "SELECT sp FROM SubscriptionPlan sp WHERE sp.subscriptionPlanName = :spname")})

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SubscriptionPlan {
	
	public SubscriptionPlan(String aSubscribtionPlanName, double aPrice) {
		subscriptionPlanName = aSubscribtionPlanName;
		price = aPrice;
	}
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=1, max=15, message="1 to 15 characters. Ex: Freemium, Gold, Platinum etc.")
	private String subscriptionPlanName;
	
	@NotNull
	private double price;
	
	public String getSubscriptionPlanName() {
		return subscriptionPlanName;
	}

	public void setSubscriptionPlanName(String subscriptionPlanName) {
		this.subscriptionPlanName = subscriptionPlanName;
	}

	public double getPrice() {
		return price;
	}
	
	public void setPrice(double aPrice) {
		this.price = aPrice;
	}
	
	public SubscriptionPlan() {
		// For JPA
	}
	
}
