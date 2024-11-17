package com.skyspacefivefiftyfive.dao;

import java.util.List;

import com.skyspacefivefiftyfive.dao.GenericDAO;
import com.skyspacefivefiftyfive.domain.Terminal;





public interface TerminalDAO extends GenericDAO<Terminal, Integer> {
  
	List<Terminal> findAll();
	






}


