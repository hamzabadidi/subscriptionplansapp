package com.hamza.subscriptionplansapp.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.hamza.subscriptionplansapp.MembersService;
import com.hamza.subscriptionplansapp.entities.member.Contact;
import com.hamza.subscriptionplansapp.entities.member.Member;

@ManagedBean
@SessionScoped
public class LastMembersBean {
	
	@Inject
	private MembersService membersService;
	
	private List<Member> lastMembers;
	
	@PostConstruct
	public void loadLastMembers() {
		lastMembers = membersService.getAllMembers();
	}
	
	public void show(Member member) {
		Contact contactDetails = member.getContactDetails();
		System.out.println(member.getId() + " - " + contactDetails.getFirstName() + " " + contactDetails.getLastName());
	}

	public List<Member> getLastMembers() {
		return lastMembers;
	}

	public void setLastMembers(List<Member> lastMembers) {
		this.lastMembers = lastMembers;
	}
	
	
	
}
