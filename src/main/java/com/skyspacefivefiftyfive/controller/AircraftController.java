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

import com.skyspacefivefiftyfive.domain.Aircraft;
import com.skyspacefivefiftyfive.dto.AircraftDTO;
import com.skyspacefivefiftyfive.dto.AircraftSearchDTO;
import com.skyspacefivefiftyfive.dto.AircraftPageDTO;
import com.skyspacefivefiftyfive.service.AircraftService;
import com.skyspacefivefiftyfive.dto.common.RequestDTO;
import com.skyspacefivefiftyfive.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/aircraft")
@RestController
public class AircraftController {

	private final static Logger logger = LoggerFactory.getLogger(AircraftController.class);

	@Autowired
	AircraftService aircraftService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Aircraft> getAll() {

		List<Aircraft> aircrafts = aircraftService.findAll();
		
		return aircrafts;	
	}

	@GetMapping(value = "/{aircraftId}")
	@ResponseBody
	public AircraftDTO getAircraft(@PathVariable Integer aircraftId) {
		
		return (aircraftService.getAircraftDTOById(aircraftId));
	}

 	@RequestMapping(value = "/addAircraft", method = RequestMethod.POST)
	public ResponseEntity<?> addAircraft(@RequestBody AircraftDTO aircraftDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = aircraftService.addAircraft(aircraftDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/aircrafts")
	public ResponseEntity<AircraftPageDTO> getAircrafts(AircraftSearchDTO aircraftSearchDTO) {
 
		return aircraftService.getAircrafts(aircraftSearchDTO);
	}	

	@RequestMapping(value = "/updateAircraft", method = RequestMethod.POST)
	public ResponseEntity<?> updateAircraft(@RequestBody AircraftDTO aircraftDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = aircraftService.updateAircraft(aircraftDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
