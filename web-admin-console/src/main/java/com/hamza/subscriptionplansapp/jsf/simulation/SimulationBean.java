package com.hamza.subscriptionplansapp.jsf.simulation;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.hamza.subscriptionplansapp.MembersGenerator;

@ManagedBean
@ApplicationScoped
public class SimulationBean {
	

	@Inject
	private MembersGenerator membersGenerator;
	
	public void createOneUser() {
		membersGenerator.createAndPersistUsers();
	}
}
