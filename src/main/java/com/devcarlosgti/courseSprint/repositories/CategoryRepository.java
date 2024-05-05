package com.devcarlosgti.courseSprint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcarlosgti.courseSprint.entities.Category;


//@Repository // essa anotação ñ é ogrado pq ja estamos implentando 
//(JpaRepository) q ja é uma anotação Spring
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	//chamo minha entidade e tipo do ID(long) dele
	
}
