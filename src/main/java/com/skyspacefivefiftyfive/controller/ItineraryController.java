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

import com.skyspacefivefiftyfive.domain.Itinerary;
import com.skyspacefivefiftyfive.dto.ItineraryDTO;
import com.skyspacefivefiftyfive.dto.ItinerarySearchDTO;
import com.skyspacefivefiftyfive.dto.ItineraryPageDTO;
import com.skyspacefivefiftyfive.service.ItineraryService;
import com.skyspacefivefiftyfive.dto.common.RequestDTO;
import com.skyspacefivefiftyfive.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/itinerary")
@RestController
public class ItineraryController {

	private final static Logger logger = LoggerFactory.getLogger(ItineraryController.class);

	@Autowired
	ItineraryService itineraryService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Itinerary> getAll() {

		List<Itinerary> itinerarys = itineraryService.findAll();
		
		return itinerarys;	
	}

	@GetMapping(value = "/{itineraryId}")
	@ResponseBody
	public ItineraryDTO getItinerary(@PathVariable Integer itineraryId) {
		
		return (itineraryService.getItineraryDTOById(itineraryId));
	}

 	@RequestMapping(value = "/addItinerary", method = RequestMethod.POST)
	public ResponseEntity<?> addItinerary(@RequestBody ItineraryDTO itineraryDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = itineraryService.addItinerary(itineraryDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/itinerarys")
	public ResponseEntity<ItineraryPageDTO> getItinerarys(ItinerarySearchDTO itinerarySearchDTO) {
 
		return itineraryService.getItinerarys(itinerarySearchDTO);
	}	

	@RequestMapping(value = "/updateItinerary", method = RequestMethod.POST)
	public ResponseEntity<?> updateItinerary(@RequestBody ItineraryDTO itineraryDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = itineraryService.updateItinerary(itineraryDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
