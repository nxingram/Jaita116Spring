package com.generation.es2springdatabase.entity;


import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "persone_new")
public class Persona {



	/*
	 * RICORDATI DI SPIEGARE @Id di tipo String
	 */
	
	@Id //chiave primaria
	@Column(name = "persona_id") //nome dell'attributo della tabella, nel caso fosse differente
	@GeneratedValue(strategy = GenerationType.IDENTITY) // l'autoincrement lo fa mysql, non java/spring
	private int personaId; 	
	
	//@Column(name = "nome") //se il nome dell'attributo mysql coincide con quello di java, @Column-name è opzionale
	@Column(length = 100)
	private String nome;
	@Column(length = 150)
	private String cognome;	
	private int eta;
	
	@JsonIgnore //nascondi lo stipendio quando generi il json nella riposta
	@Column(precision = 8, scale = 2)
	private BigDecimal stipendio;
	
	@Column(length = 100, unique = true)
	private String email;
	
	@JsonIgnore
	private String password;
	
	//relazione con indirizzo
	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
	private Indirizzo indirizzo;
	
	//https://www.baeldung.com/hibernate-one-to-many
	@OneToMany(mappedBy = "persona") //mappedBy è il nome della variabile persona nella classe macchina
	private List<Macchina> macchine; 
	
	
	//https://www.baeldung.com/jpa-many-to-many
	@ManyToMany //semplice/automatico dove non creo l'antità della tabella relazionale
	@JoinTable(
			name = "persona_scarpe",
			joinColumns = @JoinColumn(name = "persona_id"),
			inverseJoinColumns = @JoinColumn(name = "modello_id")
			)
	private List<Scarpe> scarpe;
	
	//https://www.baeldung.com/jpa-many-to-many#many-to-many-with-a-new-entity
	@OneToMany(mappedBy = "persona")
	private List<Iscrizione> iscrizioni;
	
//	public Persona(String nome, String cognome, int eta, BigDecimal stipendio, String email, String password) {
//		this.nome = nome;
//		this.cognome = cognome;
//		this.eta = eta;
//		this.stipendio = stipendio;
//		this.email = email;
//		this.password = password;
//	}
	
	//se io aggiungo un costruttore con dei parametri, devo aggiungere manualmente il costruttore vuoto
	public Persona(int personaId, String nome, String cognome, int eta, BigDecimal stipendio, String email,String password) {
		this.personaId = personaId;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.stipendio = stipendio;
		this.email = email;
		this.password = password;
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


	public Indirizzo getIndirizzo() {
		return indirizzo;
	}


	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}


	public List<Macchina> getMacchine() {
		return macchine;
	}


	public void setMacchine(List<Macchina> macchine) {
		this.macchine = macchine;
	}


	public List<Scarpe> getScarpe() {
		return scarpe;
	}


	public void setScarpe(List<Scarpe> scarpe) {
		this.scarpe = scarpe;
	}


	public List<Iscrizione> getIscrizioni() {
		return iscrizioni;
	}


	public void setIscrizioni(List<Iscrizione> iscrizioni) {
		this.iscrizioni = iscrizioni;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
}
