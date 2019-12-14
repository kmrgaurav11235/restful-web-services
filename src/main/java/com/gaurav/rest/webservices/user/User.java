package com.gaurav.rest.webservices.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private int id;
	private String lastName;
	private String firstName;
	private Date dateOfBirth;

}
