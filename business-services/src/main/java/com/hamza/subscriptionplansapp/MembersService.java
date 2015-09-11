package com.hamza.subscriptionplansapp;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hamza.subscriptionplansapp.entities.member.Member;

@Stateless
public class MembersService {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Member> getAllMembers() {
		
		Query quFindAll = em.createNamedQuery("findAllMembers", Member.class);
		
		@SuppressWarnings("unchecked")
		List<Member> allMembers = quFindAll.getResultList();
		
		return allMembers;
	}

}
