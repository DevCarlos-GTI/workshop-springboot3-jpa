package com.devcarlosgti.courseSprint.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devcarlosgti.courseSprint.entities.User;
import com.devcarlosgti.courseSprint.services.UserService;

@RestController
@RequestMapping(value = "/users")//dei um nome a essa controladora - na hora chmar la browser(navegador)
public class UserResource {

	
	//minha controladora depende dos services 
	@Autowired
	private UserService service;//criei minha dependecia
	
	//metodos para listar - p lista @GetMapping
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
	
	//metodos para inserir dados no database - PostMapping
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		
		//return ResponseEntity.ok().body(obj);//provisorio so pra test
		return ResponseEntity.created(uri).body(obj);//create espera uma URi
	}
	
	//metodos para deletar
	@DeleteMapping(value = "/{id}")//tem q passar id 
	public ResponseEntity<Void> delete(@PathVariable Long id){//p reconhecer o Long id tenho q colocar @PathVariable
		service.delete(id);
		return ResponseEntity.noContent().build();//noContent() O código de resposta HTTP de status de sucesso 204 No Content indica que a solicitação foi bem sucedida
	}
	
	//metodo p atualizar
	@PutMapping(value = "/{id}") //No HTTP, indicamos que queremos alterar um recurso por meio de requisições do tipo PUT
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
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
