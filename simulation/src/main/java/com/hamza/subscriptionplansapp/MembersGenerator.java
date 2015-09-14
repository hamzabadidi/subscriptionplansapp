package com.hamza.subscriptionplansapp;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.hamza.subscriptionplansapp.entities.member.Member;
import com.hamza.subscriptionplansapp.providers.RandomUserAPIUnmarshaller;

@Singleton
public class MembersGenerator {
	
	@PersistenceContext
	private EntityManager em;
	
	private WebTarget wt;
	
	private final static String RANDOM_USER_API_URL = "https://randomuser.me/api/";
	
	@PostConstruct
	public void initClient() {
		Client client = ClientBuilder.newBuilder().register(RandomUserAPIUnmarshaller.class).build();
		wt = client.target(RANDOM_USER_API_URL);
	}
	
	public void createAndPersistUsers() {
		
		Response response = wt.request(MediaType.APPLICATION_JSON).get();
		Member member = response.readEntity(Member.class);
		
		// TODO: Create a service to create Subscription plans. Don't get it from member object
		em.persist(member.getSubscriptionDetails().getSubscriptionPlan());
		em.persist(member.getSubscriptionDetails());
		em.persist(member.getContactDetails());
		em.persist(member);
		
	}
	
}
