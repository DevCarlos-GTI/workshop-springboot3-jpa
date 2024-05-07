package com.devcarlosgti.courseSprint.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcarlosgti.courseSprint.entities.User;
import com.devcarlosgti.courseSprint.repositories.UserRepository;

//p spring boot precisando registra a UserService(@Component) mais e serviço vamos usar(@Service)
@Service //-esta registrado com spring
public class UserService {
	
	//td q for se conectar c database tem q ter a depedencia anotação e(@Autowired) da 
	//classe e implementa (JpaRepository) e no case aqui aqui e UserReporitoory
	
	//anotação de pedencia
	@Autowired
	private UserRepository repository;

	//motodo q busue todos users(quando é todos sempre use uma lista) lista de Entidades
	public List<User> findAll(){
		return repository.findAll();//repository é a conexão e finALL e q busca todos 
	}
	
	//metodo p buscra por ID
	public User findByID(Long id) {//igual esta na Entidade
		Optional<User> obj =  repository.findById(id);
		return obj.get();//. get porder pegar 
	}
	
	//metodo p inserir dados
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	//metodo delete
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
