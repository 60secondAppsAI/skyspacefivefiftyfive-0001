package com.skyspacefivefiftyfive.dao;

import java.util.List;

import com.skyspacefivefiftyfive.dao.GenericDAO;
import com.skyspacefivefiftyfive.domain.Meal;





public interface MealDAO extends GenericDAO<Meal, Integer> {
  
	List<Meal> findAll();
	






}


