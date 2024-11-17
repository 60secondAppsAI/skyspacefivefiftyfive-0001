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
import com.skyspacefivefiftyfive.dao.PolicyDAO;
import com.skyspacefivefiftyfive.domain.Policy;
import com.skyspacefivefiftyfive.dto.PolicyDTO;
import com.skyspacefivefiftyfive.dto.PolicySearchDTO;
import com.skyspacefivefiftyfive.dto.PolicyPageDTO;
import com.skyspacefivefiftyfive.dto.PolicyConvertCriteriaDTO;
import com.skyspacefivefiftyfive.dto.common.RequestDTO;
import com.skyspacefivefiftyfive.dto.common.ResultDTO;
import com.skyspacefivefiftyfive.service.PolicyService;
import com.skyspacefivefiftyfive.util.ControllerUtils;





@Service
public class PolicyServiceImpl extends GenericServiceImpl<Policy, Integer> implements PolicyService {

    private final static Logger logger = LoggerFactory.getLogger(PolicyServiceImpl.class);

	@Autowired
	PolicyDAO policyDao;

	


	@Override
	public GenericDAO<Policy, Integer> getDAO() {
		return (GenericDAO<Policy, Integer>) policyDao;
	}
	
	public List<Policy> findAll () {
		List<Policy> policys = policyDao.findAll();
		
		return policys;	
		
	}

	public ResultDTO addPolicy(PolicyDTO policyDTO, RequestDTO requestDTO) {

		Policy policy = new Policy();

		policy.setPolicyId(policyDTO.getPolicyId());


		policy.setPolicyNumber(policyDTO.getPolicyNumber());


		policy.setDetails(policyDTO.getDetails());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		policy = policyDao.save(policy);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<Policy> getAllPolicys(Pageable pageable) {
		return policyDao.findAll(pageable);
	}

	public Page<Policy> getAllPolicys(Specification<Policy> spec, Pageable pageable) {
		return policyDao.findAll(spec, pageable);
	}

	public ResponseEntity<PolicyPageDTO> getPolicys(PolicySearchDTO policySearchDTO) {
	
			Integer policyId = policySearchDTO.getPolicyId(); 
 			String policyNumber = policySearchDTO.getPolicyNumber(); 
 			String details = policySearchDTO.getDetails(); 
 			String sortBy = policySearchDTO.getSortBy();
			String sortOrder = policySearchDTO.getSortOrder();
			String searchQuery = policySearchDTO.getSearchQuery();
			Integer page = policySearchDTO.getPage();
			Integer size = policySearchDTO.getSize();

	        Specification<Policy> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, policyId, "policyId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, policyNumber, "policyNumber"); 
			
			spec = ControllerUtils.andIfNecessary(spec, details, "details"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("policyNumber")), "%" + searchQuery.toLowerCase() + "%") 
             , cb.like(cb.lower(root.get("details")), "%" + searchQuery.toLowerCase() + "%") 
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

		Page<Policy> policys = this.getAllPolicys(spec, pageable);
		
		//System.out.println(String.valueOf(policys.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(policys.getTotalPages()));
		
		List<Policy> policysList = policys.getContent();
		
		PolicyConvertCriteriaDTO convertCriteria = new PolicyConvertCriteriaDTO();
		List<PolicyDTO> policyDTOs = this.convertPolicysToPolicyDTOs(policysList,convertCriteria);
		
		PolicyPageDTO policyPageDTO = new PolicyPageDTO();
		policyPageDTO.setPolicys(policyDTOs);
		policyPageDTO.setTotalElements(policys.getTotalElements());
		return ResponseEntity.ok(policyPageDTO);
	}

	public List<PolicyDTO> convertPolicysToPolicyDTOs(List<Policy> policys, PolicyConvertCriteriaDTO convertCriteria) {
		
		List<PolicyDTO> policyDTOs = new ArrayList<PolicyDTO>();
		
		for (Policy policy : policys) {
			policyDTOs.add(convertPolicyToPolicyDTO(policy,convertCriteria));
		}
		
		return policyDTOs;

	}
	
	public PolicyDTO convertPolicyToPolicyDTO(Policy policy, PolicyConvertCriteriaDTO convertCriteria) {
		
		PolicyDTO policyDTO = new PolicyDTO();
		
		policyDTO.setPolicyId(policy.getPolicyId());

	
		policyDTO.setPolicyNumber(policy.getPolicyNumber());

	
		policyDTO.setDetails(policy.getDetails());

	

		
		return policyDTO;
	}

	public ResultDTO updatePolicy(PolicyDTO policyDTO, RequestDTO requestDTO) {
		
		Policy policy = policyDao.getById(policyDTO.getPolicyId());

		policy.setPolicyId(ControllerUtils.setValue(policy.getPolicyId(), policyDTO.getPolicyId()));

		policy.setPolicyNumber(ControllerUtils.setValue(policy.getPolicyNumber(), policyDTO.getPolicyNumber()));

		policy.setDetails(ControllerUtils.setValue(policy.getDetails(), policyDTO.getDetails()));



        policy = policyDao.save(policy);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public PolicyDTO getPolicyDTOById(Integer policyId) {
	
		Policy policy = policyDao.getById(policyId);
			
		
		PolicyConvertCriteriaDTO convertCriteria = new PolicyConvertCriteriaDTO();
		return(this.convertPolicyToPolicyDTO(policy,convertCriteria));
	}







}
