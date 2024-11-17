package com.skyspacefivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspacefivefiftyfive.domain.Policy;
import com.skyspacefivefiftyfive.dto.PolicyDTO;
import com.skyspacefivefiftyfive.dto.PolicySearchDTO;
import com.skyspacefivefiftyfive.dto.PolicyPageDTO;
import com.skyspacefivefiftyfive.dto.PolicyConvertCriteriaDTO;
import com.skyspacefivefiftyfive.service.GenericService;
import com.skyspacefivefiftyfive.dto.common.RequestDTO;
import com.skyspacefivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface PolicyService extends GenericService<Policy, Integer> {

	List<Policy> findAll();

	ResultDTO addPolicy(PolicyDTO policyDTO, RequestDTO requestDTO);

	ResultDTO updatePolicy(PolicyDTO policyDTO, RequestDTO requestDTO);

    Page<Policy> getAllPolicys(Pageable pageable);

    Page<Policy> getAllPolicys(Specification<Policy> spec, Pageable pageable);

	ResponseEntity<PolicyPageDTO> getPolicys(PolicySearchDTO policySearchDTO);
	
	List<PolicyDTO> convertPolicysToPolicyDTOs(List<Policy> policys, PolicyConvertCriteriaDTO convertCriteria);

	PolicyDTO getPolicyDTOById(Integer policyId);







}





