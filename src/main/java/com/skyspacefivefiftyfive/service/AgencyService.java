package com.skyspacefivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspacefivefiftyfive.domain.Agency;
import com.skyspacefivefiftyfive.dto.AgencyDTO;
import com.skyspacefivefiftyfive.dto.AgencySearchDTO;
import com.skyspacefivefiftyfive.dto.AgencyPageDTO;
import com.skyspacefivefiftyfive.dto.AgencyConvertCriteriaDTO;
import com.skyspacefivefiftyfive.service.GenericService;
import com.skyspacefivefiftyfive.dto.common.RequestDTO;
import com.skyspacefivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface AgencyService extends GenericService<Agency, Integer> {

	List<Agency> findAll();

	ResultDTO addAgency(AgencyDTO agencyDTO, RequestDTO requestDTO);

	ResultDTO updateAgency(AgencyDTO agencyDTO, RequestDTO requestDTO);

    Page<Agency> getAllAgencys(Pageable pageable);

    Page<Agency> getAllAgencys(Specification<Agency> spec, Pageable pageable);

	ResponseEntity<AgencyPageDTO> getAgencys(AgencySearchDTO agencySearchDTO);
	
	List<AgencyDTO> convertAgencysToAgencyDTOs(List<Agency> agencys, AgencyConvertCriteriaDTO convertCriteria);

	AgencyDTO getAgencyDTOById(Integer agencyId);







}





