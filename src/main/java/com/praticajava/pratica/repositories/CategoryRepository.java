package com.praticajava.pratica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praticajava.pratica.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
