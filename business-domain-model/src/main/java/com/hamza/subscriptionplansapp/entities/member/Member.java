package com.hamza.subscriptionplansapp.entities.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity

@NamedQueries({@NamedQuery(name = "findAllMembers", query = "SELECT m FROM Member m"),
	   		   @NamedQuery(name = "findMemberByEmail", query = "SELECT m FROM Member m WHERE m.email = :memail")})

@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email")) 
public class Member {
	
	public Member(String anEmail, Subscription aSubscription, Contact aContact) {
		email = anEmail;
		subscriptionDetails = aSubscription;
		contactDetails = aContact;
	}
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
    @NotEmpty
    @Email(message = "Invalid format")
	private String email;
	
	@NotNull
	@OneToOne
	private Subscription subscriptionDetails;
	
	@NotNull
	@OneToOne
	private Contact contactDetails;
	
	@OneToOne
	private PaymentDetails paymentDetails;
	
	public Member() {
		// For JPA
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Subscription getSubscriptionDetails() {
		return subscriptionDetails;
	}

	public void setSubscriptionDetails(Subscription subscriptionDetails) {
		this.subscriptionDetails = subscriptionDetails;
	}

	public Contact getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(Contact contactDetails) {
		this.contactDetails = contactDetails;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	
}
