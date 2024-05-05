package com.devcarlosgti.courseSprint.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "td_product")//name da tabela no database
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto-encremento do ID
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;

	// vamos associar (p restringir vou ñ vou usar lista mais sim
	// Set (pq ele é um conjunto) assim ñ terei mais um de um conjunto de categoria
	// SET tambem é uma lista porem com reitrições de conjuntos
	@Transient //@Transient imterromp por enquanto a associação so p criar banco 
	private Set<Category> categories = new HashSet<>();// HashSet e uma classe q instancia a inteface SET
														// p q minha coleção ñ comece null mais sim vazia

	// vamos criar nossos construtores
	public Product() {
		// TODO Auto-generated constructor stub
	}

	// contrutor com argumentos ñ se colocar coleções pq ela ja esta sendo estanciada la noos atributos
	public Product(Long id, String name, String description, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	//vamos deixar somento o meoto GET em Categoria pq ele é uma coleção
	public Set<Category> getCategories() {
		return categories;
	}
	
	//o moetto SET irie comentar pq ñ se usa em coleções
		/*public void setCategories(Set<Category> categories) {
			this.categories = categories;
	}*/

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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
