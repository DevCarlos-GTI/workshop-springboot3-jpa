package com.devcarlosgti.courseSprint.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcarlosgti.courseSprint.entities.Order;
import com.devcarlosgti.courseSprint.services.OrderService;

@RestController
@RequestMapping(value = "/orders")//dei um nome a essa controladora - na hora chmar la browser(navegador)
public class OrderResource {

	
	//minha controladora depende dos services 
	@Autowired
	private OrderService service;//criei minha dependecia
	
	
	//@GetMapping define uma rota que responde a requisições HTTP GET
	//a função findALL é buscar todos - lista de users
	@GetMapping 
	public ResponseEntity<List<Order>> findAll(){ 
		
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	//p o spring enteder tengo q fazer a seguinte anotação
	//@PathVariable - indica que o valor da variável virá de uma informação da rota(no caso id da Entidade)
	//Order pq e so por id e não uma lista
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		
		Order obj = service.findByID(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
