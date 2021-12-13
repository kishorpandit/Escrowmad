package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.Product;
import com.capgemini.repo.ProductRepository;
import com.capgemini.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository repo;
	
	
	@Override
	public Integer save(Product prod) {
		prod = repo.save(prod);
		return prod.getProdId();
	}

}
