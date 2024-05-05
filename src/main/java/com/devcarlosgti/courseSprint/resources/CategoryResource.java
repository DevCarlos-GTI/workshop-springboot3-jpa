package com.devcarlosgti.courseSprint.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcarlosgti.courseSprint.entities.Category;
import com.devcarlosgti.courseSprint.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")//dei um nome a essa controladora - na hora chmar no browser(navegador)
public class CategoryResource {

	
	//minha controladora depende dos services 
	@Autowired
	private CategoryService service;//criei minha dependecia
	
	
	//@GetMapping define uma rota que responde a requisições HTTP GET
	//a função findALL é buscar todos - lista de users
	@GetMapping 
	public ResponseEntity<List<Category>> findAll(){ 
		
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	//p o spring enteder tengo q fazer a seguinte anotação
	//@PathVariable - indica que o valor da variável virá de uma informação da rota(no caso id da Entidade)
	//Category pq e so por id e não uma lista
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		
		Category obj = service.findByID(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
