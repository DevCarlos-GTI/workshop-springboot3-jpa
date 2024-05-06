package com.devcarlosgti.courseSprint.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.devcarlosgti.courseSprint.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//Classe pedido - nas Entites td e é persistencia de banco
@Entity
@Table(name = "tb_order") // criei uma anoção p ñ haver conflitos pd Order e uma palavra reservado do SQL
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	// anotação p tabela database
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// private Date moment;
	// vamos formart nosso Instant(Data)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	//vamos assocoiar OrderStatus do tipo enum da classe OrderStatus
	//private OrderStatus orderStatus;
	private Integer orderStatus;//vou mudar o Order Status p Interger p gravar no database como inteiro
	

	// associação com a classe User (tem um)
	// vamos fazer a anotação p tranformar Chave Estrangeira(Foreign Key (FK))
	// relação Muitos(Order) p um(User) * -> 1
	// @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id") // vai nome da Foreign Key (FK) , ouseja, nome da chave estranjeira
	private User client;
	
	//associar com ordem item, como OrdemItem de um id composto tenho q mapear id.order
	@OneToMany(mappedBy = "id.order")//no OrderIntem tennho uma id q pega Order e Produto entao eu coloco . em Order pois e a associação
	private Set<OrderItem> items = new HashSet<>();//como ja instaciei não precisa iniciar e sim setar
	//temos q fazer os Getters e Setters de itens agora p poder munipula-los
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {//vou iniciar  OrderStatus tambem no construtor
		super();
		this.id = id;
		this.moment = moment;
		//this.orderStatus = orderStatus;//tenho atribuir ele aqui também
		setOrderStatus(orderStatus);//so chamo operação pq alteração na classe Order
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	//criar o getters e setters do OrderStatus
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf( orderStatus); 
		//como mudei p gravar no banco como inteiro tenho chamar meu metodo(valueOf) e convert do Classe Enum
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
			//aqui no set vai ser getCode
		}
	}

	
	//getters e setters do e itens
	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
