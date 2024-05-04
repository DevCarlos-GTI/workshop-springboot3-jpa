package com.devcarlosgti.courseSprint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcarlosgti.courseSprint.entities.User;


//@Repository // essa anotação ñ é ogrado pq ja estamos implentando (JpaRepository) q ja é uma anotação Spring
public interface UserRepository extends JpaRepository<User, Long>{//chamo minha entidade e tipo do ID(long) dele
	
	//ñ precisa implementar nada pq o JpaRepository ja tem implementações prontas
	//JpaRepository e minha conexão e crição de td

}
