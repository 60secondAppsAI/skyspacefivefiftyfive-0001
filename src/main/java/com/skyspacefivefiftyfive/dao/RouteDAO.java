package com.skyspacefivefiftyfive.dao;

import java.util.List;

import com.skyspacefivefiftyfive.dao.GenericDAO;
import com.skyspacefivefiftyfive.domain.Route;





public interface RouteDAO extends GenericDAO<Route, Integer> {
  
	List<Route> findAll();
	






}


