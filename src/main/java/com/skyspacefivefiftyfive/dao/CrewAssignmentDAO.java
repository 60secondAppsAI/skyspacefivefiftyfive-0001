package com.skyspacefivefiftyfive.dao;

import java.util.List;

import com.skyspacefivefiftyfive.dao.GenericDAO;
import com.skyspacefivefiftyfive.domain.CrewAssignment;





public interface CrewAssignmentDAO extends GenericDAO<CrewAssignment, Integer> {
  
	List<CrewAssignment> findAll();
	






}


