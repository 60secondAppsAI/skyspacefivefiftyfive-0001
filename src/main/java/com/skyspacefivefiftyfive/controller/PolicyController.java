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

import com.skyspacefivefiftyfive.domain.Policy;
import com.skyspacefivefiftyfive.dto.PolicyDTO;
import com.skyspacefivefiftyfive.dto.PolicySearchDTO;
import com.skyspacefivefiftyfive.dto.PolicyPageDTO;
import com.skyspacefivefiftyfive.service.PolicyService;
import com.skyspacefivefiftyfive.dto.common.RequestDTO;
import com.skyspacefivefiftyfive.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/policy")
@RestController
public class PolicyController {

	private final static Logger logger = LoggerFactory.getLogger(PolicyController.class);

	@Autowired
	PolicyService policyService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Policy> getAll() {

		List<Policy> policys = policyService.findAll();
		
		return policys;	
	}

	@GetMapping(value = "/{policyId}")
	@ResponseBody
	public PolicyDTO getPolicy(@PathVariable Integer policyId) {
		
		return (policyService.getPolicyDTOById(policyId));
	}

 	@RequestMapping(value = "/addPolicy", method = RequestMethod.POST)
	public ResponseEntity<?> addPolicy(@RequestBody PolicyDTO policyDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = policyService.addPolicy(policyDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/policys")
	public ResponseEntity<PolicyPageDTO> getPolicys(PolicySearchDTO policySearchDTO) {
 
		return policyService.getPolicys(policySearchDTO);
	}	

	@RequestMapping(value = "/updatePolicy", method = RequestMethod.POST)
	public ResponseEntity<?> updatePolicy(@RequestBody PolicyDTO policyDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = policyService.updatePolicy(policyDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
