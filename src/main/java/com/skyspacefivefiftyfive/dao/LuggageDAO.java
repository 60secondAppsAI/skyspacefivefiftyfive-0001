package com.skyspacefivefiftyfive.dao;

import java.util.List;

import com.skyspacefivefiftyfive.dao.GenericDAO;
import com.skyspacefivefiftyfive.domain.Luggage;





public interface LuggageDAO extends GenericDAO<Luggage, Integer> {
  
	List<Luggage> findAll();
	






}


