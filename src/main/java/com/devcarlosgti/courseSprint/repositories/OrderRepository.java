package com.devcarlosgti.courseSprint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcarlosgti.courseSprint.entities.Order;


//@Repository // essa anotação ñ é ogrado pq ja estamos implentando 
//(JpaRepository) q ja é uma anotação Spring
public interface OrderRepository extends JpaRepository<Order, Long>{
	
	//chamo minha entidade e tipo do ID(long) dele
	
}
