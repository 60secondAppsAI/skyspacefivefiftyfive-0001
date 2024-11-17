package com.skyspacefivefiftyfive.dto;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import java.time.Year;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class OfferDTO {

	private Integer offerId;

	private String offerCode;

	private String description;

	private Date expirationDate;






}
