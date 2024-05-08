package com.generation.es1spring.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.es1spring.model.PersonaDTO;


/**
 * Corso java Bogliaccino 
 * https://github.com/maboglia/CorsoJava/tree/master/appunti
 * 
 * Fondamenti Bogliaccino
 * https://github.com/maboglia/Fondamenti
 * 
 * REST
 * https://github.com/maboglia/Fondamenti/blob/master/012_REST.md
 * 
 * Spring-Boot-Tutorial-base
 * https://github.com/nxingram/spring-boot-java/tree/main/Spring-Boot-Tutorial-base
 */
@RestController // controller di tipo REST
@RequestMapping("/api/json") // rotta-action rest api
public class ProvaController {
//RestController rispondere alle ichieste proventi da applicazioni o browser
	
	/**
	 * finisco qui quando chiamo l'url:
	 * "localhost:8080/api/json" con metodo "Get"
	 * produces: specifica il tipo di dato restituito nelle Response
	 * @return PersonaDTO
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) //="application/json"
	public PersonaDTO getPersona() {
		PersonaDTO persona = new PersonaDTO();
		
		persona.setNome("Fabio");
		persona.setCognome("Rossi");
		
		return persona;
	}
	
	
	/**
	 * localhost:8080/api/json/persona
	 * @param persona
	 * @return PersonaDTO
	 */
	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping("/persona") //abbreviazione di RequestMapping
	public PersonaDTO postPersona(@RequestBody PersonaDTO persona) {	
		persona.setNome(persona.getNome().toUpperCase());
		persona.setCognome(persona.getCognome().toUpperCase());
		return persona;
	}
	
	/**
	 * localhost:8080/api/json/persona/4
	 * @param id_variabile numero intero
	 * @return numero intero
	 */
	@GetMapping("/persona/{id_segnaposto}")
	public int getPersonaById(@PathVariable("id_segnaposto") int id_variabile)
	{
		return id_variabile;
	}
	
	/**
	 * Aggiungere in pom.xml la dipendenza: com.fasterxml.jackson.dataformat
	 * che trovate qui: https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml/2.17.1
	 * @param persona
	 * @return PersonaDTO in formato Xml
	 */
	@PostMapping(path = "/persona/xml", produces =  MediaType.APPLICATION_XML_VALUE) 
	public PersonaDTO postPersonaXml(@RequestBody PersonaDTO persona) {	
		persona.setNome(persona.getNome().toUpperCase());
		persona.setCognome(persona.getCognome().toUpperCase());
		return persona;
	}
	
	
	
	
	
	
}
