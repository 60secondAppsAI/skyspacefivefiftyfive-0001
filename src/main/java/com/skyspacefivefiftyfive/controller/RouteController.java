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

import com.skyspacefivefiftyfive.domain.Route;
import com.skyspacefivefiftyfive.dto.RouteDTO;
import com.skyspacefivefiftyfive.dto.RouteSearchDTO;
import com.skyspacefivefiftyfive.dto.RoutePageDTO;
import com.skyspacefivefiftyfive.service.RouteService;
import com.skyspacefivefiftyfive.dto.common.RequestDTO;
import com.skyspacefivefiftyfive.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/route")
@RestController
public class RouteController {

	private final static Logger logger = LoggerFactory.getLogger(RouteController.class);

	@Autowired
	RouteService routeService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Route> getAll() {

		List<Route> routes = routeService.findAll();
		
		return routes;	
	}

	@GetMapping(value = "/{routeId}")
	@ResponseBody
	public RouteDTO getRoute(@PathVariable Integer routeId) {
		
		return (routeService.getRouteDTOById(routeId));
	}

 	@RequestMapping(value = "/addRoute", method = RequestMethod.POST)
	public ResponseEntity<?> addRoute(@RequestBody RouteDTO routeDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = routeService.addRoute(routeDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/routes")
	public ResponseEntity<RoutePageDTO> getRoutes(RouteSearchDTO routeSearchDTO) {
 
		return routeService.getRoutes(routeSearchDTO);
	}	

	@RequestMapping(value = "/updateRoute", method = RequestMethod.POST)
	public ResponseEntity<?> updateRoute(@RequestBody RouteDTO routeDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = routeService.updateRoute(routeDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
