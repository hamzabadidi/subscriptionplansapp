/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamza.subscriptionplansapp.security.config;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.credential.Password;
import org.picketlink.idm.model.basic.User;

/**
 *
 * @author Hamza
 */
@Singleton
@Startup
public class SecurityInitializer {

    @Inject
    private PartitionManager partitionManager;

    @PostConstruct
    public void create() {
        IdentityManager identityManager = this.partitionManager.createIdentityManager();

        User user = new User("hamza");

        user.setEmail("hamza.badidi@dev.com");
        user.setFirstName("Hamza");
        user.setLastName("Badidi");

        identityManager.add(user);
        identityManager.updateCredential(user, new Password("adminadmin"));
    }
}
