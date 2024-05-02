package com.devcarlosgti.courseSprint.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcarlosgti.courseSprint.entities.User;

@RestController
@RequestMapping(value = "/users")//dei um nome a essa controladora
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		
		//faco a busca
		User u = new User(1L, "Carlos", "Carlos@gmail.com", "9999999", "123456");
		
		return ResponseEntity.ok().body(u);//aqui trago corpo(body) dando ok no meus users
	}
}
