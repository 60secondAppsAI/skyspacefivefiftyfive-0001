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

import com.skyspacefivefiftyfive.domain.Agency;
import com.skyspacefivefiftyfive.dto.AgencyDTO;
import com.skyspacefivefiftyfive.dto.AgencySearchDTO;
import com.skyspacefivefiftyfive.dto.AgencyPageDTO;
import com.skyspacefivefiftyfive.service.AgencyService;
import com.skyspacefivefiftyfive.dto.common.RequestDTO;
import com.skyspacefivefiftyfive.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/agency")
@RestController
public class AgencyController {

	private final static Logger logger = LoggerFactory.getLogger(AgencyController.class);

	@Autowired
	AgencyService agencyService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Agency> getAll() {

		List<Agency> agencys = agencyService.findAll();
		
		return agencys;	
	}

	@GetMapping(value = "/{agencyId}")
	@ResponseBody
	public AgencyDTO getAgency(@PathVariable Integer agencyId) {
		
		return (agencyService.getAgencyDTOById(agencyId));
	}

 	@RequestMapping(value = "/addAgency", method = RequestMethod.POST)
	public ResponseEntity<?> addAgency(@RequestBody AgencyDTO agencyDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = agencyService.addAgency(agencyDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/agencys")
	public ResponseEntity<AgencyPageDTO> getAgencys(AgencySearchDTO agencySearchDTO) {
 
		return agencyService.getAgencys(agencySearchDTO);
	}	

	@RequestMapping(value = "/updateAgency", method = RequestMethod.POST)
	public ResponseEntity<?> updateAgency(@RequestBody AgencyDTO agencyDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = agencyService.updateAgency(agencyDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
