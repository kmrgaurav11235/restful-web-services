package com.gaurav.rest.webservices.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {
	private String message;
	private String description;
	private Date dateTime;

	public ExceptionResponse() {
	}

}
