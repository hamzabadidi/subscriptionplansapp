package com.hamza.subscriptionplansapp.providers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Random;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import com.hamza.subscriptionplansapp.entities.member.Contact;
import com.hamza.subscriptionplansapp.entities.member.Member;
import com.hamza.subscriptionplansapp.entities.member.Subscription;
import com.hamza.subscriptionplansapp.resources.RandomUserAPIJsonKeys;
import com.hamza.subscriptionplansapp.resources.SubscriptionPlanMock;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class RandomUserAPIUnmarshaller implements MessageBodyReader<Member> {

	@Override
	public boolean isReadable(Class<?> clazz, Type arg1, Annotation[] arg2, MediaType mt) {
		boolean isSameClass = clazz == Member.class;
		return isSameClass;
	}

	@Override
	public Member readFrom(Class<Member> arg0, Type arg1, Annotation[] arg2, MediaType arg3,
			MultivaluedMap<String, String> arg4, InputStream in) throws IOException, WebApplicationException {
		
		JsonParser parser = Json.createParser(in);
		StringBuilder addressBuilder = new StringBuilder();
		
		Subscription subscription = new Subscription();
		Contact contact = new Contact();
		Member member = new Member();
		
		while(parser.hasNext()) {
			switch (parser.next()) {
            case KEY_NAME:
                String key = parser.getString();
                parser.next();
                switch (key) {
                    case RandomUserAPIJsonKeys.TITLE:
                    	contact.setTitle(parser.getString());
                        break;
                    case RandomUserAPIJsonKeys.FIRSTNAME:
                    	 contact.setFirstName(parser.getString());
                        break;
                    case RandomUserAPIJsonKeys.LASTNAME:
                    	contact.setLastName(parser.getString());
                        break;
                    case RandomUserAPIJsonKeys.STREET:
                    	addressBuilder.append(parser.getString() + " - ");
                        break;
                    case RandomUserAPIJsonKeys.CITY:
                    	addressBuilder.append(parser.getString() + " - ");
                        break;
                    case RandomUserAPIJsonKeys.STATE:
                    	addressBuilder.append(parser.getString() + " - ");
                        break;
                    case RandomUserAPIJsonKeys.ZIP:
                    	addressBuilder.append(parser.getString());
                        break;
                    
                    case RandomUserAPIJsonKeys.EMAIL:
                    	member.setEmail(parser.getString());
                        break;
                    case RandomUserAPIJsonKeys.USERNAME:
                    	subscription.setUserName(parser.getString());
                        break;
                    case RandomUserAPIJsonKeys.PASSWORD:
                    	subscription.setPassword(parser.getString());
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
			}
		}
		
		subscription.setDateOfSubscription(LocalDateTime.now());
		// Create a service that creates subscription plans. Don't create and set it here in the unmarshaller
		subscription.setSubscriptionPlan(SubscriptionPlanMock.getARandomSubscriptionPlan());
		
		contact.setDateOfBirth(getRandomDate());
		contact.setAddress(addressBuilder.toString());
		contact.setCurrentLocation(addressBuilder.toString());
		
		member.setSubscriptionDetails(subscription);
		member.setContactDetails(contact);
		
		return member;
	}
	
	private LocalDate getRandomDate() {
		int startYear = 1930;
		LocalDate start = LocalDate.of(startYear, Month.JANUARY, 1);
		Random random = new Random();
		// Make sure the returned year is before ~18 years ago:
		int deltaYears = random.nextInt(LocalDate.now().getYear() - startYear -18);
		int deltaMonths = random.nextInt(11);
		int deltaDays = random.nextInt(30);
		
		return start.plusYears(deltaYears).plusMonths(deltaMonths).plusDays(deltaDays);
	}
	
	

}
