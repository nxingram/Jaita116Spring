package com.generation.es2springdatabase.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Iscrizione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long iscrizioneId;
		
	@Column(precision = 6, scale = 2)
	private BigDecimal prezzo_vendita;
	
	private LocalDate dataIscrizione;
	private int voto;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "persona_id")
	private Persona persona;
	
	@ManyToOne()
	@JoinColumn(name = "corso_id")
	private Corso corso;

	public long getIscrizioneId() {
		return iscrizioneId;
	}

	public void setIscrizioneId(long iscrizioneId) {
		this.iscrizioneId = iscrizioneId;
	}

	public BigDecimal getPrezzo_vendita() {
		return prezzo_vendita;
	}

	public void setPrezzo_vendita(BigDecimal prezzo_vendita) {
		this.prezzo_vendita = prezzo_vendita;
	}

	public LocalDate getDataIscrizione() {
		return dataIscrizione;
	}

	public void setDataIscrizione(LocalDate dataIscrizione) {
		this.dataIscrizione = dataIscrizione;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}
}
