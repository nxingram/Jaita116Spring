package com.generation.es1spring.model;

public class IndirizzoDTO {

	private String via;
	private int numeroCivico;
	
	public IndirizzoDTO(String via, int numeroCivico) {
		this.via = via;
		this.numeroCivico = numeroCivico;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public int getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(int numeroCivico) {
		this.numeroCivico = numeroCivico;
	}
	
	
	
	
}
