package com.devcarlosgti.courseSprint.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcarlosgti.courseSprint.entities.Product;
import com.devcarlosgti.courseSprint.services.ProductService;

@RestController
@RequestMapping(value = "/products")//dei um nome a essa controladora - na hora chmar no browser(navegador)
public class ProductResource {

	
	//minha controladora depende dos services 
	@Autowired
	private ProductService service;//criei minha dependecia
	
	
	//@GetMapping define uma rota que responde a requisições HTTP GET
	//a função findALL é buscar todos - lista de users
	@GetMapping 
	public ResponseEntity<List<Product>> findAll(){ 
		
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	//p o spring enteder tengo q fazer a seguinte anotação
	//@PathVariable - indica que o valor da variável virá de uma informação da rota(no caso id da Entidade)
	//Product pq e so por id e não uma lista
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		
		Product obj = service.findByID(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
