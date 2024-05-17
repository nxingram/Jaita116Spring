package com.generation.es2springdatabase.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "corsi")
public class Corso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long corso_id;
	
	@Column(length = 50)
	private String nome;
	
	private int capienza;
	
	@Column(precision = 6, scale = 2)
	private BigDecimal prezzo_listino;
	
	@JsonIgnore
	@OneToMany(mappedBy = "corso")
	private List<Iscrizione> iscrizioni;

	public long getCorso_id() {
		return corso_id;
	}

	public void setCorso_id(long corso_id) {
		this.corso_id = corso_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCapienza() {
		return capienza;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}

	public BigDecimal getPrezzo_listino() {
		return prezzo_listino;
	}

	public void setPrezzo_listino(BigDecimal prezzo_listino) {
		this.prezzo_listino = prezzo_listino;
	}

	public List<Iscrizione> getIscrizioni() {
		return iscrizioni;
	}

	public void setIscrizioni(List<Iscrizione> iscrizioni) {
		this.iscrizioni = iscrizioni;
	}
	
}
