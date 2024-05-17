package com.generation.es2springdatabase.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "macchine")
public class Macchina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long macchinaId;

	@Column(length = 50)
	private String marca;
	
	@Column(length = 50)
	private String modello;
	
	@Column(length = 50, unique = true)
	private String targa;

	//https://www.baeldung.com/hibernate-one-to-many
	@JsonIgnore
	@ManyToOne //- per relazione bidirezionale
	@JoinColumn(name = "persona_id", nullable = false)
	private Persona persona;

	public long getMacchinaId() {
		return macchinaId;
	}

	public void setMacchinaId(long macchinaId) {
		this.macchinaId = macchinaId;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}
}
