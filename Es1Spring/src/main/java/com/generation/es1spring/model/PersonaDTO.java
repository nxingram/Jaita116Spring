package com.generation.es1spring.model;

//https://it.wikipedia.org/wiki/Oggetto_di_trasferimento_dati
public class PersonaDTO {

	private String nome;
	private String cognome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
}
