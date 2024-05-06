package com.devcarlosgti.courseSprint.entities.pk;

import java.io.Serializable;

import com.devcarlosgti.courseSprint.entities.Order;
import com.devcarlosgti.courseSprint.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//Classe auxiliar p gerar um chave primaria composta de produto e pedido(Order) 
//e quando se relaciona com duas classe ou tabelas ao mesmo tempo
@Embeddable//chave primária compost
public class OrderItemPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne//muitos p um
	@JoinColumn(name = "order_id")//nome da chave primaria
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	//ñ usa contrutor pois ñ será necessarios iniciado aqui mais sim na Classe OrderItem 
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	//nesse vai ser comparado os dois
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		OrderItemPK other = (OrderItemPK) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	
	
}
