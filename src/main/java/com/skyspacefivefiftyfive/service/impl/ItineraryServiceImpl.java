package com.skyspacefivefiftyfive.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



import com.skyspacefivefiftyfive.dao.GenericDAO;
import com.skyspacefivefiftyfive.service.GenericService;
import com.skyspacefivefiftyfive.service.impl.GenericServiceImpl;
import com.skyspacefivefiftyfive.dao.ItineraryDAO;
import com.skyspacefivefiftyfive.domain.Itinerary;
import com.skyspacefivefiftyfive.dto.ItineraryDTO;
import com.skyspacefivefiftyfive.dto.ItinerarySearchDTO;
import com.skyspacefivefiftyfive.dto.ItineraryPageDTO;
import com.skyspacefivefiftyfive.dto.ItineraryConvertCriteriaDTO;
import com.skyspacefivefiftyfive.dto.common.RequestDTO;
import com.skyspacefivefiftyfive.dto.common.ResultDTO;
import com.skyspacefivefiftyfive.service.ItineraryService;
import com.skyspacefivefiftyfive.util.ControllerUtils;





@Service
public class ItineraryServiceImpl extends GenericServiceImpl<Itinerary, Integer> implements ItineraryService {

    private final static Logger logger = LoggerFactory.getLogger(ItineraryServiceImpl.class);

	@Autowired
	ItineraryDAO itineraryDao;

	


	@Override
	public GenericDAO<Itinerary, Integer> getDAO() {
		return (GenericDAO<Itinerary, Integer>) itineraryDao;
	}
	
	public List<Itinerary> findAll () {
		List<Itinerary> itinerarys = itineraryDao.findAll();
		
		return itinerarys;	
		
	}

	public ResultDTO addItinerary(ItineraryDTO itineraryDTO, RequestDTO requestDTO) {

		Itinerary itinerary = new Itinerary();

		itinerary.setItineraryId(itineraryDTO.getItineraryId());


		itinerary.setSeatNumber(itineraryDTO.getSeatNumber());


		itinerary.setClassType(itineraryDTO.getClassType());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		itinerary = itineraryDao.save(itinerary);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<Itinerary> getAllItinerarys(Pageable pageable) {
		return itineraryDao.findAll(pageable);
	}

	public Page<Itinerary> getAllItinerarys(Specification<Itinerary> spec, Pageable pageable) {
		return itineraryDao.findAll(spec, pageable);
	}

	public ResponseEntity<ItineraryPageDTO> getItinerarys(ItinerarySearchDTO itinerarySearchDTO) {
	
			Integer itineraryId = itinerarySearchDTO.getItineraryId(); 
 			String seatNumber = itinerarySearchDTO.getSeatNumber(); 
 			String classType = itinerarySearchDTO.getClassType(); 
 			String sortBy = itinerarySearchDTO.getSortBy();
			String sortOrder = itinerarySearchDTO.getSortOrder();
			String searchQuery = itinerarySearchDTO.getSearchQuery();
			Integer page = itinerarySearchDTO.getPage();
			Integer size = itinerarySearchDTO.getSize();

	        Specification<Itinerary> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, itineraryId, "itineraryId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, seatNumber, "seatNumber"); 
			
			spec = ControllerUtils.andIfNecessary(spec, classType, "classType"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("seatNumber")), "%" + searchQuery.toLowerCase() + "%") 
             , cb.like(cb.lower(root.get("classType")), "%" + searchQuery.toLowerCase() + "%") 
		));}
		
		Sort sort = Sort.unsorted();
		if (sortBy != null && !sortBy.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			if (sortOrder.equalsIgnoreCase("asc")) {
				sort = Sort.by(sortBy).ascending();
			} else if (sortOrder.equalsIgnoreCase("desc")) {
				sort = Sort.by(sortBy).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<Itinerary> itinerarys = this.getAllItinerarys(spec, pageable);
		
		//System.out.println(String.valueOf(itinerarys.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(itinerarys.getTotalPages()));
		
		List<Itinerary> itinerarysList = itinerarys.getContent();
		
		ItineraryConvertCriteriaDTO convertCriteria = new ItineraryConvertCriteriaDTO();
		List<ItineraryDTO> itineraryDTOs = this.convertItinerarysToItineraryDTOs(itinerarysList,convertCriteria);
		
		ItineraryPageDTO itineraryPageDTO = new ItineraryPageDTO();
		itineraryPageDTO.setItinerarys(itineraryDTOs);
		itineraryPageDTO.setTotalElements(itinerarys.getTotalElements());
		return ResponseEntity.ok(itineraryPageDTO);
	}

	public List<ItineraryDTO> convertItinerarysToItineraryDTOs(List<Itinerary> itinerarys, ItineraryConvertCriteriaDTO convertCriteria) {
		
		List<ItineraryDTO> itineraryDTOs = new ArrayList<ItineraryDTO>();
		
		for (Itinerary itinerary : itinerarys) {
			itineraryDTOs.add(convertItineraryToItineraryDTO(itinerary,convertCriteria));
		}
		
		return itineraryDTOs;

	}
	
	public ItineraryDTO convertItineraryToItineraryDTO(Itinerary itinerary, ItineraryConvertCriteriaDTO convertCriteria) {
		
		ItineraryDTO itineraryDTO = new ItineraryDTO();
		
		itineraryDTO.setItineraryId(itinerary.getItineraryId());

	
		itineraryDTO.setSeatNumber(itinerary.getSeatNumber());

	
		itineraryDTO.setClassType(itinerary.getClassType());

	

		
		return itineraryDTO;
	}

	public ResultDTO updateItinerary(ItineraryDTO itineraryDTO, RequestDTO requestDTO) {
		
		Itinerary itinerary = itineraryDao.getById(itineraryDTO.getItineraryId());

		itinerary.setItineraryId(ControllerUtils.setValue(itinerary.getItineraryId(), itineraryDTO.getItineraryId()));

		itinerary.setSeatNumber(ControllerUtils.setValue(itinerary.getSeatNumber(), itineraryDTO.getSeatNumber()));

		itinerary.setClassType(ControllerUtils.setValue(itinerary.getClassType(), itineraryDTO.getClassType()));



        itinerary = itineraryDao.save(itinerary);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public ItineraryDTO getItineraryDTOById(Integer itineraryId) {
	
		Itinerary itinerary = itineraryDao.getById(itineraryId);
			
		
		ItineraryConvertCriteriaDTO convertCriteria = new ItineraryConvertCriteriaDTO();
		return(this.convertItineraryToItineraryDTO(itinerary,convertCriteria));
	}







}
