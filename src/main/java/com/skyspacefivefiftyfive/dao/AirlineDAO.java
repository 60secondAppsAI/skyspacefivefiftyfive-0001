package com.skyspacefivefiftyfive.dao;

import java.util.List;

import com.skyspacefivefiftyfive.dao.GenericDAO;
import com.skyspacefivefiftyfive.domain.Airline;





public interface AirlineDAO extends GenericDAO<Airline, Integer> {
  
	List<Airline> findAll();
	






}


