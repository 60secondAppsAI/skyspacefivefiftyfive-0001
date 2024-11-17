package com.skyspacefivefiftyfive.dao;

import java.util.List;

import com.skyspacefivefiftyfive.dao.GenericDAO;
import com.skyspacefivefiftyfive.domain.LoyaltyProgram;





public interface LoyaltyProgramDAO extends GenericDAO<LoyaltyProgram, Integer> {
  
	List<LoyaltyProgram> findAll();
	






}


