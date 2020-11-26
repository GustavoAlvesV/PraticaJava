package com.praticajava.pratica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praticajava.pratica.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}
