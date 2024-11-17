package com.skyspacefivefiftyfive.dao;

import java.util.List;

import com.skyspacefivefiftyfive.dao.GenericDAO;
import com.skyspacefivefiftyfive.domain.Agency;





public interface AgencyDAO extends GenericDAO<Agency, Integer> {
  
	List<Agency> findAll();
	






}


