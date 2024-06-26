package com.devcarlosgti.courseSprint.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")//renomei minha tabela pq User da classe vai conflito
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//(@GeneratedValue) auto-encrementado(anotação p JPA )o id
	//private Integer id;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 
	
	private String name;
	private String email;
	private String phone;
	private String password;
	
	//associação com pedido(Classe Order) tem * (* = varios)
	//como tem uma coleção(quando coleção ñ usa set(pq ñ pode alterar) so usa GET temos Instaciar o array tambem
	@JsonIgnore // @JsonIgnore ele(spring.jpa.open-in-view=true) da application.propertities e interrompe o loop infinito da associação e traz o item associado
	@OneToMany(mappedBy = "client") // tenho q onde esta mapeado minha relação (OneToMany) 1 p *
	private List<Order> orders = new ArrayList<>();
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//somente metodo Get para coleção (lista) pq ñ pode ser alterada
	public List<Order> getOrders() {
		return orders;
	}
	
	//hastcode serve p comparar
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



}
