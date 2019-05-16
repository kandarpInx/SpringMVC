package com.common.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<E,I> extends Serializable {
	
	public List<E> getAll();

	public void save(E e);

	public E get(I id);
	
	public void delete(E e);
	
	public void update(E e);

}
