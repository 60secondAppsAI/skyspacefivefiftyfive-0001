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

import com.skyspacefivefiftyfive.domain.Terminal;
import com.skyspacefivefiftyfive.dto.TerminalDTO;
import com.skyspacefivefiftyfive.dto.TerminalSearchDTO;
import com.skyspacefivefiftyfive.dto.TerminalPageDTO;
import com.skyspacefivefiftyfive.service.TerminalService;
import com.skyspacefivefiftyfive.dto.common.RequestDTO;
import com.skyspacefivefiftyfive.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/terminal")
@RestController
public class TerminalController {

	private final static Logger logger = LoggerFactory.getLogger(TerminalController.class);

	@Autowired
	TerminalService terminalService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Terminal> getAll() {

		List<Terminal> terminals = terminalService.findAll();
		
		return terminals;	
	}

	@GetMapping(value = "/{terminalId}")
	@ResponseBody
	public TerminalDTO getTerminal(@PathVariable Integer terminalId) {
		
		return (terminalService.getTerminalDTOById(terminalId));
	}

 	@RequestMapping(value = "/addTerminal", method = RequestMethod.POST)
	public ResponseEntity<?> addTerminal(@RequestBody TerminalDTO terminalDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = terminalService.addTerminal(terminalDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/terminals")
	public ResponseEntity<TerminalPageDTO> getTerminals(TerminalSearchDTO terminalSearchDTO) {
 
		return terminalService.getTerminals(terminalSearchDTO);
	}	

	@RequestMapping(value = "/updateTerminal", method = RequestMethod.POST)
	public ResponseEntity<?> updateTerminal(@RequestBody TerminalDTO terminalDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = terminalService.updateTerminal(terminalDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
