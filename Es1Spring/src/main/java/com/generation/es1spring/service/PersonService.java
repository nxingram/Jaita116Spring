package com.generation.es1spring.service;

import org.springframework.stereotype.Service;

import com.generation.es1spring.model.IndirizzoDTO;
import com.generation.es1spring.model.PersonaDTO;

/**
 * Qui metto la logica Business relativa alla persona,
 * cioè tutte le logiche dell'applicativo relative alla gestione delle persone
 */
@Service
public class PersonService {

	/**
	 * ToUpper
	 * @param persona
	 * @return PersonaDTO persona
	 */
	public PersonaDTO toUpper(PersonaDTO persona)
	{
		persona.setNome(persona.getNome().toUpperCase());
		persona.setCognome(persona.getCognome().toUpperCase());
		return persona;
	}
	
	public PersonaDTO nuovaPersonaDefaut() {		
		PersonaDTO persona = new PersonaDTO();		
		persona.setNome("Fabio");
		persona.setCognome("Rossi");
		persona.setCodicefiscale("codicefiscaelefinto");
		persona.setIndirizzo(new IndirizzoDTO("Via Pisa", 3));
		return persona;
	}
	

	
}
