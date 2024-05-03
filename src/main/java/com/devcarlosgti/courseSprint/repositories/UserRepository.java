package com.devcarlosgti.courseSprint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcarlosgti.courseSprint.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{//chamo minha entidade e tipo do ID dele
	
	//ñ precisa implementar nada pq o JpaRepository ja tem implementações prontas

}
