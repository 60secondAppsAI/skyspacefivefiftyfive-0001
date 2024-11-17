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
import com.skyspacefivefiftyfive.dao.AgencyBookingDAO;
import com.skyspacefivefiftyfive.domain.AgencyBooking;
import com.skyspacefivefiftyfive.dto.AgencyBookingDTO;
import com.skyspacefivefiftyfive.dto.AgencyBookingSearchDTO;
import com.skyspacefivefiftyfive.dto.AgencyBookingPageDTO;
import com.skyspacefivefiftyfive.dto.AgencyBookingConvertCriteriaDTO;
import com.skyspacefivefiftyfive.dto.common.RequestDTO;
import com.skyspacefivefiftyfive.dto.common.ResultDTO;
import com.skyspacefivefiftyfive.service.AgencyBookingService;
import com.skyspacefivefiftyfive.util.ControllerUtils;





@Service
public class AgencyBookingServiceImpl extends GenericServiceImpl<AgencyBooking, Integer> implements AgencyBookingService {

    private final static Logger logger = LoggerFactory.getLogger(AgencyBookingServiceImpl.class);

	@Autowired
	AgencyBookingDAO agencyBookingDao;

	


	@Override
	public GenericDAO<AgencyBooking, Integer> getDAO() {
		return (GenericDAO<AgencyBooking, Integer>) agencyBookingDao;
	}
	
	public List<AgencyBooking> findAll () {
		List<AgencyBooking> agencyBookings = agencyBookingDao.findAll();
		
		return agencyBookings;	
		
	}

	public ResultDTO addAgencyBooking(AgencyBookingDTO agencyBookingDTO, RequestDTO requestDTO) {

		AgencyBooking agencyBooking = new AgencyBooking();

		agencyBooking.setAgencyBookingId(agencyBookingDTO.getAgencyBookingId());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		agencyBooking = agencyBookingDao.save(agencyBooking);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<AgencyBooking> getAllAgencyBookings(Pageable pageable) {
		return agencyBookingDao.findAll(pageable);
	}

	public Page<AgencyBooking> getAllAgencyBookings(Specification<AgencyBooking> spec, Pageable pageable) {
		return agencyBookingDao.findAll(spec, pageable);
	}

	public ResponseEntity<AgencyBookingPageDTO> getAgencyBookings(AgencyBookingSearchDTO agencyBookingSearchDTO) {
	
			Integer agencyBookingId = agencyBookingSearchDTO.getAgencyBookingId(); 
 			String sortBy = agencyBookingSearchDTO.getSortBy();
			String sortOrder = agencyBookingSearchDTO.getSortOrder();
			String searchQuery = agencyBookingSearchDTO.getSearchQuery();
			Integer page = agencyBookingSearchDTO.getPage();
			Integer size = agencyBookingSearchDTO.getSize();

	        Specification<AgencyBooking> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, agencyBookingId, "agencyBookingId"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

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

		Page<AgencyBooking> agencyBookings = this.getAllAgencyBookings(spec, pageable);
		
		//System.out.println(String.valueOf(agencyBookings.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(agencyBookings.getTotalPages()));
		
		List<AgencyBooking> agencyBookingsList = agencyBookings.getContent();
		
		AgencyBookingConvertCriteriaDTO convertCriteria = new AgencyBookingConvertCriteriaDTO();
		List<AgencyBookingDTO> agencyBookingDTOs = this.convertAgencyBookingsToAgencyBookingDTOs(agencyBookingsList,convertCriteria);
		
		AgencyBookingPageDTO agencyBookingPageDTO = new AgencyBookingPageDTO();
		agencyBookingPageDTO.setAgencyBookings(agencyBookingDTOs);
		agencyBookingPageDTO.setTotalElements(agencyBookings.getTotalElements());
		return ResponseEntity.ok(agencyBookingPageDTO);
	}

	public List<AgencyBookingDTO> convertAgencyBookingsToAgencyBookingDTOs(List<AgencyBooking> agencyBookings, AgencyBookingConvertCriteriaDTO convertCriteria) {
		
		List<AgencyBookingDTO> agencyBookingDTOs = new ArrayList<AgencyBookingDTO>();
		
		for (AgencyBooking agencyBooking : agencyBookings) {
			agencyBookingDTOs.add(convertAgencyBookingToAgencyBookingDTO(agencyBooking,convertCriteria));
		}
		
		return agencyBookingDTOs;

	}
	
	public AgencyBookingDTO convertAgencyBookingToAgencyBookingDTO(AgencyBooking agencyBooking, AgencyBookingConvertCriteriaDTO convertCriteria) {
		
		AgencyBookingDTO agencyBookingDTO = new AgencyBookingDTO();
		
		agencyBookingDTO.setAgencyBookingId(agencyBooking.getAgencyBookingId());

	

		
		return agencyBookingDTO;
	}

	public ResultDTO updateAgencyBooking(AgencyBookingDTO agencyBookingDTO, RequestDTO requestDTO) {
		
		AgencyBooking agencyBooking = agencyBookingDao.getById(agencyBookingDTO.getAgencyBookingId());

		agencyBooking.setAgencyBookingId(ControllerUtils.setValue(agencyBooking.getAgencyBookingId(), agencyBookingDTO.getAgencyBookingId()));



        agencyBooking = agencyBookingDao.save(agencyBooking);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public AgencyBookingDTO getAgencyBookingDTOById(Integer agencyBookingId) {
	
		AgencyBooking agencyBooking = agencyBookingDao.getById(agencyBookingId);
			
		
		AgencyBookingConvertCriteriaDTO convertCriteria = new AgencyBookingConvertCriteriaDTO();
		return(this.convertAgencyBookingToAgencyBookingDTO(agencyBooking,convertCriteria));
	}







}
