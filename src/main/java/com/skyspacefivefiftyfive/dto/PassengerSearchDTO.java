package com.skyspacefivefiftyfive.dto;

import java.sql.Timestamp;
import java.time.Year;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PassengerSearchDTO {

	private Integer page = 0;
	private Integer size;
	private String sortBy;
	private String sortOrder;
	private String searchQuery;

	private Integer passengerId;
	
	private String firstName;
	
	private String lastName;
	
	private String emailAddress;
	
	private String phoneNumber;
	
}
