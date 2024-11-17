package com.skyspacefivefiftyfive.dao;

import java.util.List;

import com.skyspacefivefiftyfive.dao.GenericDAO;
import com.skyspacefivefiftyfive.domain.Crew;





public interface CrewDAO extends GenericDAO<Crew, Integer> {
  
	List<Crew> findAll();
	






}


