package com.gaurav.rest.webservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private int id;
	@Size(min = 2, message = "Last name should be atleast two characters long.")
	private String lastName;
	private String firstName;
	@Past(message = "Date of Birth should be in the past.")
	private Date dateOfBirth;

}
