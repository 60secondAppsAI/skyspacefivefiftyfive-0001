package com.skyspacefivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspacefivefiftyfive.domain.Route;
import com.skyspacefivefiftyfive.dto.RouteDTO;
import com.skyspacefivefiftyfive.dto.RouteSearchDTO;
import com.skyspacefivefiftyfive.dto.RoutePageDTO;
import com.skyspacefivefiftyfive.dto.RouteConvertCriteriaDTO;
import com.skyspacefivefiftyfive.service.GenericService;
import com.skyspacefivefiftyfive.dto.common.RequestDTO;
import com.skyspacefivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface RouteService extends GenericService<Route, Integer> {

	List<Route> findAll();

	ResultDTO addRoute(RouteDTO routeDTO, RequestDTO requestDTO);

	ResultDTO updateRoute(RouteDTO routeDTO, RequestDTO requestDTO);

    Page<Route> getAllRoutes(Pageable pageable);

    Page<Route> getAllRoutes(Specification<Route> spec, Pageable pageable);

	ResponseEntity<RoutePageDTO> getRoutes(RouteSearchDTO routeSearchDTO);
	
	List<RouteDTO> convertRoutesToRouteDTOs(List<Route> routes, RouteConvertCriteriaDTO convertCriteria);

	RouteDTO getRouteDTOById(Integer routeId);







}





