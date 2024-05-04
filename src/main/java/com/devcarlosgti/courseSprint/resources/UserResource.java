package com.devcarlosgti.courseSprint.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcarlosgti.courseSprint.entities.User;
import com.devcarlosgti.courseSprint.services.UserService;

@RestController
@RequestMapping(value = "/users")//dei um nome a essa controladora - na hora chmar la browser(navegador)
public class UserResource {

	
	//minha controladora depende dos services 
	@Autowired
	private UserService service;//criei minha dependecia
	
	@GetMapping //@GetMapping define uma rota que responde a requisições HTTP GET
	public ResponseEntity<List<User>> findAll(){//a função findALL é buscar todos 
		//lista de users
		
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){//p o spring enteder tengo q fazer a seguinte anotação
		//@PathVariable - indica que o valor da variável virá de uma informação da rota(no caso id da Entidade)
		//User pq e so por id e não uma lista
		
		User obj = service.findByID(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	
		//forma manual
	/*public ResponseEntity<User> findAll(){
		//faco a busca
		User u = new User(1L, "Carlos", "Carlos@gmail.com", "9999999", "123456"); 
		//feito manualmente so p test 
				
		return ResponseEntity.ok().body(u);//aqui trago corpo(body) dando ok no meus users
		
	}*/
}
