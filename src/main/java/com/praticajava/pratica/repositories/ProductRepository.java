package com.praticajava.pratica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praticajava.pratica.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
