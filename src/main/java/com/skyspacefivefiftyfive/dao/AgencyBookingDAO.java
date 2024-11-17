package com.skyspacefivefiftyfive.dao;

import java.util.List;

import com.skyspacefivefiftyfive.dao.GenericDAO;
import com.skyspacefivefiftyfive.domain.AgencyBooking;





public interface AgencyBookingDAO extends GenericDAO<AgencyBooking, Integer> {
  
	List<AgencyBooking> findAll();
	






}


