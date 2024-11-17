package com.skyspacefivefiftyfive.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.skyspacefivefiftyfive.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.skyspacefivefiftyfive.domain.AgencyBooking;
import com.skyspacefivefiftyfive.dto.AgencyBookingDTO;
import com.skyspacefivefiftyfive.dto.AgencyBookingSearchDTO;
import com.skyspacefivefiftyfive.dto.AgencyBookingPageDTO;
import com.skyspacefivefiftyfive.service.AgencyBookingService;
import com.skyspacefivefiftyfive.dto.common.RequestDTO;
import com.skyspacefivefiftyfive.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/agencyBooking")
@RestController
public class AgencyBookingController {

	private final static Logger logger = LoggerFactory.getLogger(AgencyBookingController.class);

	@Autowired
	AgencyBookingService agencyBookingService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<AgencyBooking> getAll() {

		List<AgencyBooking> agencyBookings = agencyBookingService.findAll();
		
		return agencyBookings;	
	}

	@GetMapping(value = "/{agencyBookingId}")
	@ResponseBody
	public AgencyBookingDTO getAgencyBooking(@PathVariable Integer agencyBookingId) {
		
		return (agencyBookingService.getAgencyBookingDTOById(agencyBookingId));
	}

 	@RequestMapping(value = "/addAgencyBooking", method = RequestMethod.POST)
	public ResponseEntity<?> addAgencyBooking(@RequestBody AgencyBookingDTO agencyBookingDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = agencyBookingService.addAgencyBooking(agencyBookingDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/agencyBookings")
	public ResponseEntity<AgencyBookingPageDTO> getAgencyBookings(AgencyBookingSearchDTO agencyBookingSearchDTO) {
 
		return agencyBookingService.getAgencyBookings(agencyBookingSearchDTO);
	}	

	@RequestMapping(value = "/updateAgencyBooking", method = RequestMethod.POST)
	public ResponseEntity<?> updateAgencyBooking(@RequestBody AgencyBookingDTO agencyBookingDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = agencyBookingService.updateAgencyBooking(agencyBookingDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
