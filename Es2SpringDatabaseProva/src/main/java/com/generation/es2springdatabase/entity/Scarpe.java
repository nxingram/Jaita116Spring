package com.generation.es2springdatabase.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
//@Table(name = "scarpe")
public class Scarpe {

	@Id
	private String modello_id;
	
	private String Colore;

	@JsonIgnore
	@ManyToMany(mappedBy = "scarpe")
	private List<Persona> persone;

	public List<Persona> getPersone() {
		return persone;
	}

	public void setPersone(List<Persona> persone) {
		this.persone = persone;
	}




	public String getColore() {
		return Colore;
	}

	public void setColore(String colore) {
		Colore = colore;
	}

	public String getModello_id() {
		return modello_id;
	}

	public void setModello_id(String modello_id) {
		this.modello_id = modello_id;
	}

}
