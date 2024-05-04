package com.devcarlosgti.courseSprint.entities;

import java.io.Serializable;
import java.time.Instant;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Classe pedido - nas Entites td e é persistencia de banco
@Entity
@Table(name = "tb_order")//criei uma anoção p ñ haver conflitos pd Order e uma palavra reservado do SQL
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//anotação p tabela database
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//private Date moment;
	private Instant moment;
	
	//associação com a classe User (tem um)
	//vamos fazer a anotação p tranformar Chave Estrangeira(Foreign Key (FK))
	//relação Muitos(Order) p um(User) * -> 1
	@ManyToOne
	@JoinColumn(name = "client_id") // vai nome da Foreign Key (FK) , ousej, nome da chave estranjeira
	private User client;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(Long id, Instant moment, User client) {
		super();
		this.id = id;
		this.moment = moment;
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
