package com.capgemini.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
