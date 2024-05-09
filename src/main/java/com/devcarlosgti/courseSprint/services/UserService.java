package com.devcarlosgti.courseSprint.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcarlosgti.courseSprint.entities.User;
import com.devcarlosgti.courseSprint.repositories.UserRepository;
import com.devcarlosgti.courseSprint.services.exceptions.ResourceNotFoundException;

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
		//return obj.get();//. get porder pegar 
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));//se ñ encontrar o id dar uma exceção
	}
	
	//metodo p inserir dados
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	//metodo delete
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	//metodo update
	public User update(Long id, User obj) {
		//User entity = repository.getOne(id); getONE dexou de uso agora é getReferenceById
		//vai sedeixar no ponto para poder trabalhar com database
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);//esse metdodo serar criado
		return repository.save(entity);
	}

	//aqui vamos atualizar o campos ou atributos da classe 
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		//entity.setPassword(obj.getPassword()); ñ vou permitir atulizar a senha e nem o Id
	}
}
