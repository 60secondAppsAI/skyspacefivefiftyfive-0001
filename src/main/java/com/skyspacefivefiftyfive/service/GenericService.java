package com.skyspacefivefiftyfive.service;

import com.skyspacefivefiftyfive.dao.GenericDAO;

public interface GenericService<T, ID> {

    abstract GenericDAO<T, ID> getDAO();

    T getById(Integer id) ;

}