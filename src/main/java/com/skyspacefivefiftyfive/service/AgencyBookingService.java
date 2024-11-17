package com.skyspacefivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspacefivefiftyfive.domain.AgencyBooking;
import com.skyspacefivefiftyfive.dto.AgencyBookingDTO;
import com.skyspacefivefiftyfive.dto.AgencyBookingSearchDTO;
import com.skyspacefivefiftyfive.dto.AgencyBookingPageDTO;
import com.skyspacefivefiftyfive.dto.AgencyBookingConvertCriteriaDTO;
import com.skyspacefivefiftyfive.service.GenericService;
import com.skyspacefivefiftyfive.dto.common.RequestDTO;
import com.skyspacefivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface AgencyBookingService extends GenericService<AgencyBooking, Integer> {

	List<AgencyBooking> findAll();

	ResultDTO addAgencyBooking(AgencyBookingDTO agencyBookingDTO, RequestDTO requestDTO);

	ResultDTO updateAgencyBooking(AgencyBookingDTO agencyBookingDTO, RequestDTO requestDTO);

    Page<AgencyBooking> getAllAgencyBookings(Pageable pageable);

    Page<AgencyBooking> getAllAgencyBookings(Specification<AgencyBooking> spec, Pageable pageable);

	ResponseEntity<AgencyBookingPageDTO> getAgencyBookings(AgencyBookingSearchDTO agencyBookingSearchDTO);
	
	List<AgencyBookingDTO> convertAgencyBookingsToAgencyBookingDTOs(List<AgencyBooking> agencyBookings, AgencyBookingConvertCriteriaDTO convertCriteria);

	AgencyBookingDTO getAgencyBookingDTOById(Integer agencyBookingId);







}





