package com.generation.es1spring.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

//https://it.wikipedia.org/wiki/Oggetto_di_trasferimento_dati
public class PersonaDTO {

	private String nome;
	private String cognome;
	private IndirizzoDTO indirizzo; //chiave esterna indirizzo_id
	//private ArrayList<String> foto;
	
	//restituisco solo i dati necessari, e nascondo le informazioni personali
	//con l'annotazione @JsonIgnore sull'attributo della classe PersonDTO
	@JsonIgnore
	private String codicefiscale;
	
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
	
	public IndirizzoDTO getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(IndirizzoDTO indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getCodicefiscale() {
		return codicefiscale;
	}
	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}
	
	
	
	
}
