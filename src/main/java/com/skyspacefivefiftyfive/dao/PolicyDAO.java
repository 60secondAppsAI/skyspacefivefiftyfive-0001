package com.skyspacefivefiftyfive.dao;

import java.util.List;

import com.skyspacefivefiftyfive.dao.GenericDAO;
import com.skyspacefivefiftyfive.domain.Policy;





public interface PolicyDAO extends GenericDAO<Policy, Integer> {
  
	List<Policy> findAll();
	






}


