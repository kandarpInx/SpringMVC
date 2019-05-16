package com.service;

import org.springframework.stereotype.Service;

import com.common.service.GenericServiceImpl;
import com.model.Items;

@Service
public class ItemsServiceImpl extends GenericServiceImpl<Items, Integer> implements ItemsService {

	private static final long serialVersionUID = 1L;

}
