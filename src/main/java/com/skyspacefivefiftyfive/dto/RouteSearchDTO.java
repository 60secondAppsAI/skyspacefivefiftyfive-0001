package com.skyspacefivefiftyfive.dto;

import java.sql.Timestamp;
import java.time.Year;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RouteSearchDTO {

	private Integer page = 0;
	private Integer size;
	private String sortBy;
	private String sortOrder;
	private String searchQuery;

	private Integer routeId;
	
	private String origin;
	
	private String destination;
	
	private double distance;
	
}
