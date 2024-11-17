package com.skyspacefivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspacefivefiftyfive.domain.BaggageClaim;
import com.skyspacefivefiftyfive.dto.BaggageClaimDTO;
import com.skyspacefivefiftyfive.dto.BaggageClaimSearchDTO;
import com.skyspacefivefiftyfive.dto.BaggageClaimPageDTO;
import com.skyspacefivefiftyfive.dto.BaggageClaimConvertCriteriaDTO;
import com.skyspacefivefiftyfive.service.GenericService;
import com.skyspacefivefiftyfive.dto.common.RequestDTO;
import com.skyspacefivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface BaggageClaimService extends GenericService<BaggageClaim, Integer> {

	List<BaggageClaim> findAll();

	ResultDTO addBaggageClaim(BaggageClaimDTO baggageClaimDTO, RequestDTO requestDTO);

	ResultDTO updateBaggageClaim(BaggageClaimDTO baggageClaimDTO, RequestDTO requestDTO);

    Page<BaggageClaim> getAllBaggageClaims(Pageable pageable);

    Page<BaggageClaim> getAllBaggageClaims(Specification<BaggageClaim> spec, Pageable pageable);

	ResponseEntity<BaggageClaimPageDTO> getBaggageClaims(BaggageClaimSearchDTO baggageClaimSearchDTO);
	
	List<BaggageClaimDTO> convertBaggageClaimsToBaggageClaimDTOs(List<BaggageClaim> baggageClaims, BaggageClaimConvertCriteriaDTO convertCriteria);

	BaggageClaimDTO getBaggageClaimDTOById(Integer baggageClaimId);







}





