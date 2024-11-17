package com.skyspacefivefiftyfive.dao;

import java.util.List;

import com.skyspacefivefiftyfive.dao.GenericDAO;
import com.skyspacefivefiftyfive.domain.Ticket;





public interface TicketDAO extends GenericDAO<Ticket, Integer> {
  
	List<Ticket> findAll();
	






}


