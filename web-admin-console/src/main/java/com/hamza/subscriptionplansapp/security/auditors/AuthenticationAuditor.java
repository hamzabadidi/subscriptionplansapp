package com.hamza.subscriptionplansapp.security.auditors;


import javax.enterprise.event.Observes;

import org.picketlink.authentication.event.LoggedInEvent;
import org.picketlink.authentication.event.LoginFailedEvent;
import org.picketlink.authentication.event.PostLoggedOutEvent;

public class AuthenticationAuditor {
	
	public void onLogginSuccessful(@Observes LoggedInEvent ev) {
		System.out.println("\n\nSuccessful Login\n\n");
	}
	
	public void onLoginFailed(@Observes LoginFailedEvent ev) {
		System.out.println("\n\nFailed Login\n\n");
	}
	
	public void onLoggout(@Observes PostLoggedOutEvent ev) {
		System.out.println("\n\nLogged out\n\n");
	}
	
}