package com.skyspacefivefiftyfive.dao;

import java.util.List;

import com.skyspacefivefiftyfive.dao.GenericDAO;
import com.skyspacefivefiftyfive.domain.Aircraft;





public interface AircraftDAO extends GenericDAO<Aircraft, Integer> {
  
	List<Aircraft> findAll();
	






}


