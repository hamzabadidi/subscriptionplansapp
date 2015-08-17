package com.hamza.subscriptionplansapp.test.persistence.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hamza.subscriptionplansapp.admin.entities.plans.SubscriptionPlan;
import com.hamza.subscriptionplansapp.entities.member.Contact;
import com.hamza.subscriptionplansapp.entities.member.Member;
import com.hamza.subscriptionplansapp.entities.member.Subscription;

@Singleton
@Startup
public class TestDataCreator {
	
	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	private void createMembers() {
		
		SubscriptionPlan plan = new SubscriptionPlan( "Premium", 29.99);
		em.persist(plan);
		SubscriptionPlan plan2 = new SubscriptionPlan( "Gold", 9.99);
		em.persist(plan2);
		SubscriptionPlan plan3 = new SubscriptionPlan( "Free", 0.00);
		em.persist(plan3);
		
		Subscription subscribtionDetails = new Subscription(LocalDateTime.now(), "zyriab", "mysecretpassword", plan);
		em.persist(subscribtionDetails);
		
		Contact contactDetails = new Contact("Hamza", "Badidi", LocalDate.of(1983, Month.OCTOBER, 21), "Munich", "Partnachplatz");
		em.persist(contactDetails);

		
		Member hamza = new Member("hb@domain.com", subscribtionDetails, contactDetails);
		em.persist(hamza);
	}

}
