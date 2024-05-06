package com.devcarlosgti.courseSprint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcarlosgti.courseSprint.entities.OrderItem;
import com.devcarlosgti.courseSprint.entities.pk.OrderItemPK;


//@Repository // essa anotação ñ é ogrado pq ja estamos implentando 
//(JpaRepository) q ja é uma anotação Spring
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{
	
	//chamo minha entidade e tipo do ID(OrderItemPK PKcomposta) dele
	
}
