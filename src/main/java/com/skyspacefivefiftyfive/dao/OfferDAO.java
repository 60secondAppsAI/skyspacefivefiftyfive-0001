package com.skyspacefivefiftyfive.dao;

import java.util.List;

import com.skyspacefivefiftyfive.dao.GenericDAO;
import com.skyspacefivefiftyfive.domain.Offer;





public interface OfferDAO extends GenericDAO<Offer, Integer> {
  
	List<Offer> findAll();
	






}


