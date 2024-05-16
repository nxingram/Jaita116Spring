package com.generation.es2springdatabase.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "indirizzi")
public class Indirizzo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long indirizzoId;

	@Column(nullable = false)
	private String via;
	@Column(nullable = false)
	private String civico;
	@Column(nullable = false)
	private String citta;
	@Column(length = 2, nullable = false)
	private String provincia;
	@Column(length = 5, nullable = false)
	private String cap;

	//metodo manuale
	//@Column(name = "persona_id")
//	private int personaId;
	
	//https://www.baeldung.com/jpa-one-to-one
	//con relazione uno a uno
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "persona_id" , referencedColumnName = "persona_id") //referencedColumnName se l'id di persona è scritto in modo diverso es: id_pers
	private Persona persona;

	public long getIndirizzoId() {
		return indirizzoId;
	}

	public void setIndirizzoId(long indirizzoId) {
		this.indirizzoId = indirizzoId;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
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

//	public int getPersonaId() {
//		return personaId;
//	}
//
//	public void setPersonaId(int personaId) {
//		this.personaId = personaId;
//	}
	
	
	
	


}
