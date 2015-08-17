package com.hamza.subscriptionplansapp.test.persistence;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hamza.subscriptionplansapp.admin.entities.plans.SubscriptionPlan;
import com.hamza.subscriptionplansapp.entities.member.Member;
import com.hamza.subscriptionplansapp.test.persistence.util.MemberServiceTest;
import com.hamza.subscriptionplansapp.test.persistence.util.TestDataCreator;


@RunWith(Arquillian.class)
public class PersistenceTest {
	
	private static final String CDI_ACTIVATION_FILE = "beans.xml";
	
	@Inject
	private MemberServiceTest memberService;
	
	@Deployment
	public static JavaArchive createDeployment() {
		
		return ShrinkWrap.create(JavaArchive.class, "testpersistence.jar")
					.addClasses(MemberServiceTest.class, TestDataCreator.class)
					.addPackage(Member.class.getPackage()) // Get all the classes in that package
					.addPackage(SubscriptionPlan.class.getPackage()) // Get all the classes in that package
					.addAsResource("persistence-test-h2.xml", "META-INF/persistence.xml")
					.addAsManifestResource(EmptyAsset.INSTANCE, CDI_ACTIVATION_FILE);
	}
	
	@Test
	public void testIsDeployed() {
		Assert.assertNotNull(memberService);
	}
	
	@Test
	public void testMemeberRegistration() {
		List<Member> allMembers = memberService.getAllMembers();
		Assert.assertEquals("Unexpected size of initial list of trainees", 1, allMembers.size());
		
	}
	
}
