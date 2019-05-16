package com.dao;

import org.springframework.stereotype.Repository;

import com.common.dao.GenericDAOImpl;
import com.model.Items;

@Repository
public class ItemsDAOImpls<E, I> extends GenericDAOImpl<Items, Integer> implements ItemsDAO {

	private static final long serialVersionUID = 1L;
	
}
