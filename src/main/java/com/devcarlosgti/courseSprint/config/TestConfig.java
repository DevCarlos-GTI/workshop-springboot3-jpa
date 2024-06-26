package com.devcarlosgti.courseSprint.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devcarlosgti.courseSprint.entities.Category;
import com.devcarlosgti.courseSprint.entities.Order;
import com.devcarlosgti.courseSprint.entities.OrderItem;
import com.devcarlosgti.courseSprint.entities.Payment;
import com.devcarlosgti.courseSprint.entities.Product;
import com.devcarlosgti.courseSprint.entities.User;
import com.devcarlosgti.courseSprint.entities.enums.OrderStatus;
import com.devcarlosgti.courseSprint.repositories.CategoryRepository;
import com.devcarlosgti.courseSprint.repositories.OrderItemRepository;
import com.devcarlosgti.courseSprint.repositories.OrderRepository;
import com.devcarlosgti.courseSprint.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	//inserção de usuarios na minha tabela(ouseja salvar no banco)
	@Override
	public void run(String... args) throws Exception {
		
		//inserir Category
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers");
		
		//inserir Product
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		
		//vamos salvar category no database(obs.: posso salvar aqui pq não tem depencia ainda de outra classe)
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		//vamos salvar Product no database
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		//vamos fazer as associações de produtos e categorias
		p1.getCategories().add(cat2);//eu to aqui q meu p1 pertence a categoria cat2
		
		p2.getCategories().add(cat1);//aqui to q o protudo p2 pertence tanto a categoria cat1 e cat3
		p2.getCategories().add(cat3);
		
		p3.getCategories().add(cat3);
		
		p4.getCategories().add(cat3);
		
		p5.getCategories().add(cat2);
		
		//vamos salvar agora as associações muitos p muitos de produto com categoria
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));//so chamo a operação novament de salvar
		
		
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
		
		//como se associar todos vou colocar aqui 
		//inserir OrderItem
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		//inser um payment, eu nem preciso de um Repository de payment pq ele ja dependo de Order
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);//vc ñ salva payment mais sim o pedido(Order)	
		
		//vamos salvar
		orderRepository.save(o1);
	}
	
	

}
