package com.skyspacefivefiftyfive.dto;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import java.time.Year;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class FlightDTO {

	private Integer flightId;

	private String flightNumber;

	private String departureAirport;

	private String arrivalAirport;

	private Date departureTime;

	private Date arrivalTime;






}
