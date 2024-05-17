package com.generation.es2springdatabase.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
//@Table(name = "scarpe")
public class Scarpe {

	@Id
	private String modelloId;
	
	private String colore;

	@JsonIgnore
	@ManyToMany(mappedBy = "scarpe")
	private List<Persona> persone;

	public List<Persona> getPersone() {
		return persone;
	}

	public void setPersone(List<Persona> persone) {
		this.persone = persone;
	}

	public String getModelloId() {
		return modelloId;
	}

	public void setModelloId(String modelloId) {
		this.modelloId = modelloId;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	
}