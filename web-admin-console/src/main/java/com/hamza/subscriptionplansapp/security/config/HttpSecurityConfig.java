package com.hamza.subscriptionplansapp.security.config;

import javax.enterprise.event.Observes;

import org.picketlink.config.SecurityConfigurationBuilder;
import org.picketlink.event.SecurityConfigurationEvent;

public class HttpSecurityConfig {
	
	public void onInit(@Observes SecurityConfigurationEvent e) {
		
		SecurityConfigurationBuilder secBuilder = e.getBuilder();
		System.out.println("\n\n\nInjected: " + secBuilder + "\n\n\n");
                
                secBuilder.http()
                        .allPaths().authenticateWith()
                            .form()
                                .authenticationUri("/login.jsf")
                                .loginPage("/login.jsf")
                                .errorPage("/error.jsf")
                                .restoreOriginalRequest()
                        .forPath("/javax.faces.resource/*").unprotected()
                        .forPath("/logout")
                            .logout()
                            .redirectTo("/index.html");
                
	}

}
