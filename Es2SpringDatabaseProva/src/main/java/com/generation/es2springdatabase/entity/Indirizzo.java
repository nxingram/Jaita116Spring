package com.generation.es2springdatabase.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Indirizzo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int indirizzoId;

	@Column(nullable = false)
	private String via;
	@Column(nullable = false)
	private String numero;
	@Column(nullable = false)
	private String citta;
	@Column(nullable = false, length = 2)
	private String provincia;
	@Column(length = 5,nullable = false)
	private String cap;
	
	//https://www.baeldung.com/jpa-one-to-one
	@JsonIgnore
	@OneToOne(mappedBy = "indirizzo")
	private Persona persona;

	public int getIndirizzoId() {
		return indirizzoId;
	}

	public void setIndirizzoId(int indirizzoId) {
		this.indirizzoId = indirizzoId;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
}
