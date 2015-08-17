package com.hamza.subscriptionplansapp.entities.member;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class Contact {
	
	public Contact(String aFirstName, String aLastName, LocalDate aDateOfBirth, String anAddress, String aCurrentLocation) {
		firstName = aFirstName;
		lastName = aLastName;
		dateOfBirth = aDateOfBirth;
		address = anAddress;
		currentLocation = aCurrentLocation;
	}
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Size(min = 1, max = 25, message = "1-25 letters and spaces")
	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String firstName;
	
	@NotNull
	@Size(min = 1, max = 25, message = "1-25 letters and spaces")
	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String lastName;
	
	@NotNull
	private LocalDate dateOfBirth;
	
	@NotNull
	private String address;
	
	@NotNull
	private String currentLocation;
	
	public Contact() {
		// For JPA
	}
	
}
