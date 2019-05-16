package com.common.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.dao.GenericDAO;

@Service
public abstract class GenericServiceImpl<E,I extends Serializable> implements GenericService<E, I> {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private GenericDAO<E, I> genericDAO;

	@Override
	@Transactional
	public List<E> getAll() {
		return genericDAO.getAll();
	}

	@Override
	@Transactional
	public void save(E e) {
		// TODO Auto-generated method stub
		genericDAO.save(e);
	}

	@Override
	@Transactional
	public E get(I id) {
		// TODO Auto-generated method stub
		return genericDAO.get(id);
	}

	@Override
	@Transactional
	public void delete(E entity) {
		// TODO Auto-generated method stub
		genericDAO.delete(entity);
	}

	@Override
	@Transactional
	public void update(E e) {
		// TODO Auto-generated method stub
		genericDAO.update(e);
	}

}
