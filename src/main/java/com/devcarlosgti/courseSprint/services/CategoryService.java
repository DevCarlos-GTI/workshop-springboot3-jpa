package com.devcarlosgti.courseSprint.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcarlosgti.courseSprint.entities.Category;
import com.devcarlosgti.courseSprint.repositories.CategoryRepository;

//p spring boot precisando registra a CategoryService(@Component) mais e serviço vamos usar(@Service)
@Service //-esta registrado com spring
public class CategoryService {
	
	//td q for se conectar c database tem q ter a depedencia anotação e(@Autowired) da 
	//classe e implementa (JpaRepository) e no case aqui aqui e CategoryReporitoory
	
	//anotação de pedencia
	@Autowired
	private CategoryRepository repository;

	//motodo q busue todos users(quando é todos sempre use uma lista) lista de Entidades
	public List<Category> findAll(){
		return repository.findAll();//repository é a conexão e finALL e q busca todos 
	}
	
	//metodo p buscra por ID
	public Category findByID(Long id) {//igual esta na Entidade
		Optional<Category> obj =  repository.findById(id);
		return obj.get();//. get porder pegar 
	}
}
