package com.skyspacefivefiftyfive.dao;

import java.util.List;

import com.skyspacefivefiftyfive.dao.GenericDAO;
import com.skyspacefivefiftyfive.domain.Itinerary;





public interface ItineraryDAO extends GenericDAO<Itinerary, Integer> {
  
	List<Itinerary> findAll();
	






}


