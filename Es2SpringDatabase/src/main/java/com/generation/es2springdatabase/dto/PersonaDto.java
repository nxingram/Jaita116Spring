package com.generation.es2springdatabase.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.generation.es2springdatabase.entity.Persona;

public class PersonaDto {
	private int personaId; 	
	private String nome;
	private String cognome;
	private int eta;
	private BigDecimal stipendio;
	private String email;
	private String password;	
	
	//conversione/mappatura da un tipo Dto ad Entità
	public Persona toPersona()
	{
		return new Persona(
				this.getPersonaId(),
				this.getNome(),
				this.getCognome(),
				this.getEta(),
				this.getStipendio(),
				this.getEmail(),
				this.getPassword()
				);
	}
	//conversione/mappatura da un tipo entita a dto
	public PersonaDto toPersonaDto(Persona p)
	{
		PersonaDto dto = new PersonaDto();
		dto.setPersonaId(p.getPersonaId());
		dto.setNome(p.getNome());
		dto.setCognome(p.getCognome());
		dto.setEta(p.getEta());
		dto.setStipendio(p.getStipendio());
		dto.setEmail(p.getEmail());
		dto.setPassword(p.getPassword());
		return dto;
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

	public BigDecimal getStipendio() {
		return stipendio;
	}

	public void setStipendio(BigDecimal stipendio) {
		this.stipendio = stipendio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
