package com.devcarlosgti.courseSprint.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devcarlosgti.courseSprint.entities.Category;
import com.devcarlosgti.courseSprint.entities.Order;
import com.devcarlosgti.courseSprint.entities.User;
import com.devcarlosgti.courseSprint.entities.enums.OrderStatus;
import com.devcarlosgti.courseSprint.repositories.CategoryRepository;
import com.devcarlosgti.courseSprint.repositories.OrderRepository;
import com.devcarlosgti.courseSprint.repositories.UserRepository;

//Classe para test
@Configuration
@Profile("test")//esse vem la do meu application.properties(spring.profiles.active=test)
public class TestConfig implements CommandLineRunner{
	//CommandLineRunner - é uma inteface q execute a aplicação e esta dentro do metodo run
	
	//vamos criar depedencia(@Autowired)
	@Autowired
	private UserRepository userRepository;//ele acesso os dados

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	//inserção de usuarios na minha tabela(ouseja salvar no banco)
	@Override
	public void run(String... args) throws Exception {
		
		//inserir Category
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers");
		
		//vamos salvar category no database(obs.: posso salvar aqui pq não tem depencia ainda de outra classe)
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		//inserir User
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//vamos inserir Order ( como tem associação com User coloquie os usuarios no final(u1))
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); //tenho colocar tambem a OrderStatus(Pago) pq esta associado
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

		//vamos salvar no database
		userRepository.saveAll(Arrays.asList(u1,u2));//estou salvando uma lista de users
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
	

}
