package com.skyspacefivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspacefivefiftyfive.domain.Itinerary;
import com.skyspacefivefiftyfive.dto.ItineraryDTO;
import com.skyspacefivefiftyfive.dto.ItinerarySearchDTO;
import com.skyspacefivefiftyfive.dto.ItineraryPageDTO;
import com.skyspacefivefiftyfive.dto.ItineraryConvertCriteriaDTO;
import com.skyspacefivefiftyfive.service.GenericService;
import com.skyspacefivefiftyfive.dto.common.RequestDTO;
import com.skyspacefivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface ItineraryService extends GenericService<Itinerary, Integer> {

	List<Itinerary> findAll();

	ResultDTO addItinerary(ItineraryDTO itineraryDTO, RequestDTO requestDTO);

	ResultDTO updateItinerary(ItineraryDTO itineraryDTO, RequestDTO requestDTO);

    Page<Itinerary> getAllItinerarys(Pageable pageable);

    Page<Itinerary> getAllItinerarys(Specification<Itinerary> spec, Pageable pageable);

	ResponseEntity<ItineraryPageDTO> getItinerarys(ItinerarySearchDTO itinerarySearchDTO);
	
	List<ItineraryDTO> convertItinerarysToItineraryDTOs(List<Itinerary> itinerarys, ItineraryConvertCriteriaDTO convertCriteria);

	ItineraryDTO getItineraryDTOById(Integer itineraryId);







}





