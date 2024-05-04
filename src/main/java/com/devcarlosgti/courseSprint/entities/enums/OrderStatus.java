package com.devcarlosgti.courseSprint.entities.enums;

public enum OrderStatus {
	
//ESPERANDO_PAGAMENTO, PAGO, ENVIADO,ENTREGUE,CANCELADO
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);

	//p implemnetar um codigo no itens vamos criar um construtor enum (construtor em Enum é private)
	
	private int code; //crio minha variável 
	
	//construtor so pra iniciar os codigos
	private OrderStatus (int code) {
		this.code = code;
	}
	
	//vamos deixar esse metodo acessivel(o get eu posso pegar)
	public int getCode() {
		return code;
	}
	
	//vamos tambem fazer um metodo static(ou seja, ñ precisa instanciar) p converter numerico em enumerado
	public static OrderStatus valueOf(int code) {
		
		//p isso vamos todos os valores de Orders Status
		for(OrderStatus value: OrderStatus.values()) {
			
			//vamos testa se o codigo e de quem diz ser
			if(value.getCode() == code) {
				return  value;
			}
		}
		
		//se ñ achar o codigo,  o user informou codigo q ñ esta lista enumerada
		throw new IllegalArgumentException("Invalid Order Status code! ");
	}
	
}
