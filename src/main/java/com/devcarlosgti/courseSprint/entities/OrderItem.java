package com.devcarlosgti.courseSprint.entities;

import java.io.Serializable;

import com.devcarlosgti.courseSprint.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//Classe item pedido
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//indentificador(id) vai ser nossa chave primaria composta criada la da classe OrderItemPK
	@EmbeddedId//so chave composta
	private OrderItemPK id = new OrderItemPK();//temos instaciar
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	//como meu OrderItemPk pega tanto product quanto order vou iniciar manualmente aqui no construtor
	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();
		//vou setar eles usando id por isso ñ foi inicido - isso acontece quando se usa chave p composta
		id.setOrder(order);
		id.setProduct(product);
		
		this.quantity = quantity;
		this.price = price;
	}
	
	//tenho q criar os gettes e setters do Order e Products p poder manipula-los
	@JsonIgnore//como e composto coloco no get pois ele pega Order e ignora mao dupla p loop 
	public Order getOrder() {
		return id.getOrder();//nesse tenho usar o id pois ele q ta associado
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);//ñ precisa do this
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}

	//getters e setters automaticos
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
