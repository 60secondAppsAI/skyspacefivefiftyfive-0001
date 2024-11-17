package com.skyspacefivefiftyfive.dao;

import java.util.List;

import com.skyspacefivefiftyfive.dao.GenericDAO;
import com.skyspacefivefiftyfive.domain.BaggageClaim;





public interface BaggageClaimDAO extends GenericDAO<BaggageClaim, Integer> {
  
	List<BaggageClaim> findAll();
	






}


