package com.hamza.subscriptionplansapp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hamza.subscriptionplansapp.admin.entities.plans.SubscriptionPlan;
import com.hamza.subscriptionplansapp.entities.member.Contact;
import com.hamza.subscriptionplansapp.entities.member.Member;
import com.hamza.subscriptionplansapp.entities.member.Subscription;

@Singleton
@Startup
public class InitialMembersGenerator {
	
	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	public void createData() {
		
		// TODO: Create a simulation project to create sample data
		//       Use https://randomuser.me/api/
		//TODO: Use Logger
		System.out.println("\nMember Creation\n");
		
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
