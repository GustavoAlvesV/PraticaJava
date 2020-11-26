package com.praticajava.pratica.entities.enums;

public enum OrderStatus {
	WAITING_PAYMENT(1),
	PAID(2),
	PACKING(3),
	SHIPPED(4),
	DELIVERED(5),
	CANCELED(6);
	
	//Codigo do tipo enumerado
	private int code;

	//Construtor do tipo enumerado
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value:OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código inválido.");
	}
	
}
