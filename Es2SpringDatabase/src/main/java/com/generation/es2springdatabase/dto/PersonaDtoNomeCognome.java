package com.generation.es2springdatabase.dto;

public class PersonaDtoNomeCognome {

	private String nome;
	private String cognome;
	
	public PersonaDtoNomeCognome() {
	}

	public PersonaDtoNomeCognome(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

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
