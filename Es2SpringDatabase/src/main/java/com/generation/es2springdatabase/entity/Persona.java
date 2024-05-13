package com.generation.es2springdatabase.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persone")
public class Persona {

	@Id //chiave primaria
	@Column(name = "persona_id") //nome dell'attributo della tabella, nel caso fosse differente
	@GeneratedValue(strategy = GenerationType.IDENTITY) // l'autoincrement lo fa mysql, non java/spring
	private int personaId; 	
	
	//@Column(name = "nome") //se il nome dell'attributo mysql coincide con quello di java, @Column-name è opzionale
	private String nome;
	private String cognome;	
	private int eta;
	
	@JsonIgnore //nascondi lo stipendio quando generi il json nella riposta
	private double stipendio;
	
	
	//se io aggiungo un costtore con dei parametri, devo aggiungere manualmente il costruttore vuoto
	public Persona(int personaId, String nome, String cognome, int eta, double stipendio) {
		this.personaId = personaId;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.stipendio = stipendio;
	}
	public Persona( String nome, String cognome, int eta, double stipendio) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.stipendio = stipendio;
	}
	
	//
	/**
	 * spring ha bisogno di un costruttore vuoto
	 */
	public Persona() {
		
	}


	public int getPersonaId() {
		return personaId;
	}


	public void setPersonaId(int personaId) {
		this.personaId = personaId;
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


	public int getEta() {
		return eta;
	}


	public void setEta(int eta) {
		this.eta = eta;
	}


	public double getStipendio() {
		return stipendio;
	}


	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
