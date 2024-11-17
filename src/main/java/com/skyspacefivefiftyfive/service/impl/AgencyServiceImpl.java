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
import com.skyspacefivefiftyfive.dao.AgencyDAO;
import com.skyspacefivefiftyfive.domain.Agency;
import com.skyspacefivefiftyfive.dto.AgencyDTO;
import com.skyspacefivefiftyfive.dto.AgencySearchDTO;
import com.skyspacefivefiftyfive.dto.AgencyPageDTO;
import com.skyspacefivefiftyfive.dto.AgencyConvertCriteriaDTO;
import com.skyspacefivefiftyfive.dto.common.RequestDTO;
import com.skyspacefivefiftyfive.dto.common.ResultDTO;
import com.skyspacefivefiftyfive.service.AgencyService;
import com.skyspacefivefiftyfive.util.ControllerUtils;





@Service
public class AgencyServiceImpl extends GenericServiceImpl<Agency, Integer> implements AgencyService {

    private final static Logger logger = LoggerFactory.getLogger(AgencyServiceImpl.class);

	@Autowired
	AgencyDAO agencyDao;

	


	@Override
	public GenericDAO<Agency, Integer> getDAO() {
		return (GenericDAO<Agency, Integer>) agencyDao;
	}
	
	public List<Agency> findAll () {
		List<Agency> agencys = agencyDao.findAll();
		
		return agencys;	
		
	}

	public ResultDTO addAgency(AgencyDTO agencyDTO, RequestDTO requestDTO) {

		Agency agency = new Agency();

		agency.setAgencyId(agencyDTO.getAgencyId());


		agency.setName(agencyDTO.getName());


		agency.setContactInformation(agencyDTO.getContactInformation());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		agency = agencyDao.save(agency);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<Agency> getAllAgencys(Pageable pageable) {
		return agencyDao.findAll(pageable);
	}

	public Page<Agency> getAllAgencys(Specification<Agency> spec, Pageable pageable) {
		return agencyDao.findAll(spec, pageable);
	}

	public ResponseEntity<AgencyPageDTO> getAgencys(AgencySearchDTO agencySearchDTO) {
	
			Integer agencyId = agencySearchDTO.getAgencyId(); 
 			String name = agencySearchDTO.getName(); 
 			String contactInformation = agencySearchDTO.getContactInformation(); 
 			String sortBy = agencySearchDTO.getSortBy();
			String sortOrder = agencySearchDTO.getSortOrder();
			String searchQuery = agencySearchDTO.getSearchQuery();
			Integer page = agencySearchDTO.getPage();
			Integer size = agencySearchDTO.getSize();

	        Specification<Agency> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, agencyId, "agencyId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, name, "name"); 
			
			spec = ControllerUtils.andIfNecessary(spec, contactInformation, "contactInformation"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("name")), "%" + searchQuery.toLowerCase() + "%") 
             , cb.like(cb.lower(root.get("contactInformation")), "%" + searchQuery.toLowerCase() + "%") 
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

		Page<Agency> agencys = this.getAllAgencys(spec, pageable);
		
		//System.out.println(String.valueOf(agencys.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(agencys.getTotalPages()));
		
		List<Agency> agencysList = agencys.getContent();
		
		AgencyConvertCriteriaDTO convertCriteria = new AgencyConvertCriteriaDTO();
		List<AgencyDTO> agencyDTOs = this.convertAgencysToAgencyDTOs(agencysList,convertCriteria);
		
		AgencyPageDTO agencyPageDTO = new AgencyPageDTO();
		agencyPageDTO.setAgencys(agencyDTOs);
		agencyPageDTO.setTotalElements(agencys.getTotalElements());
		return ResponseEntity.ok(agencyPageDTO);
	}

	public List<AgencyDTO> convertAgencysToAgencyDTOs(List<Agency> agencys, AgencyConvertCriteriaDTO convertCriteria) {
		
		List<AgencyDTO> agencyDTOs = new ArrayList<AgencyDTO>();
		
		for (Agency agency : agencys) {
			agencyDTOs.add(convertAgencyToAgencyDTO(agency,convertCriteria));
		}
		
		return agencyDTOs;

	}
	
	public AgencyDTO convertAgencyToAgencyDTO(Agency agency, AgencyConvertCriteriaDTO convertCriteria) {
		
		AgencyDTO agencyDTO = new AgencyDTO();
		
		agencyDTO.setAgencyId(agency.getAgencyId());

	
		agencyDTO.setName(agency.getName());

	
		agencyDTO.setContactInformation(agency.getContactInformation());

	

		
		return agencyDTO;
	}

	public ResultDTO updateAgency(AgencyDTO agencyDTO, RequestDTO requestDTO) {
		
		Agency agency = agencyDao.getById(agencyDTO.getAgencyId());

		agency.setAgencyId(ControllerUtils.setValue(agency.getAgencyId(), agencyDTO.getAgencyId()));

		agency.setName(ControllerUtils.setValue(agency.getName(), agencyDTO.getName()));

		agency.setContactInformation(ControllerUtils.setValue(agency.getContactInformation(), agencyDTO.getContactInformation()));



        agency = agencyDao.save(agency);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public AgencyDTO getAgencyDTOById(Integer agencyId) {
	
		Agency agency = agencyDao.getById(agencyId);
			
		
		AgencyConvertCriteriaDTO convertCriteria = new AgencyConvertCriteriaDTO();
		return(this.convertAgencyToAgencyDTO(agency,convertCriteria));
	}







}
