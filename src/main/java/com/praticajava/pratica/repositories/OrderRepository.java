package com.praticajava.pratica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praticajava.pratica.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
