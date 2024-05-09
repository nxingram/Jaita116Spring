package com.generation.es1spring.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.generation.es1spring.model.PersonaDTO;
import com.generation.es1spring.service.PersonService;


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
 * 
 * Jaita116Spring
 * https://github.com/nxingram/Jaita116Spring/tree/main
 * 
 * 
 * RestController rispondere alle ichieste proventi da applicazioni o browser
 */
@RestController // controller di tipo REST
@RequestMapping("/api/persona") // rotta-action rest api
public class PersonaController {

	// se non instanzio la classe, la variabile è NULL!
	//uso annotazione spring per inizializzare l'oggetto
	//IoC: inversion of control - Dependency injection
	@Autowired 
	PersonService personaSrv; 
		
	//alternativa utilizzando il costruttore
//	@Autowired - non necessario
//	public PersonaController(PersonService personaSrv) {
//		this.personaSrv = personaSrv;
//	}
	
	
	/**
	 * finisco qui quando chiamo l'url:
	 * "localhost:8080/api/persona" con metodo "Get"
	 * produces: specifica il tipo di dato restituito nelle Response
	 * @return PersonaDTO
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) //="application/json"
	public PersonaDTO getPersona() {
//		PersonaDTO persona = new PersonaDTO();		
//		persona.setNome("Fabio3");
//		persona.setCognome("Rossi");
//		
//		return persona;
		PersonaDTO personaDef = personaSrv.nuovaPersonaDefaut();
		//restituisco solo i dati necessari, e nascondo le informazioni personali
		//con l'annotazione @JsonIgnore sull'attributo della classe PersonDTO
		System.out.println(personaDef.getCodicefiscale()); 
		return personaDef;
	}
	
	/**
	 * "localhost:8080/api/persona/xml" con metodo "Get"
	 * POJO = plain old java object
	 */
	@GetMapping(path = "/xml", produces = MediaType.APPLICATION_XML_VALUE) //="application/xml"
	public PersonaDTO getPersonaXml()
	{
//		PersonaDTO persona = new PersonaDTO();		
//		persona.setNome("Fabio3");
//		persona.setCognome("Rossi");
//		
//		return persona;
		return personaSrv.nuovaPersonaDefaut();
	}
	
	
	
	/**
	 * localhost:8080/api/persona con metodo Post
	 * @param persona
	 * @return PersonaDTO
	 */
	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping() //abbreviazione di RequestMapping
	public PersonaDTO postPersona(@RequestBody PersonaDTO persona) {	
//		persona.setNome(persona.getNome().toUpperCase());
//		persona.setCognome(persona.getCognome().toUpperCase());
//		return persona;
		PersonaDTO personaUpper =  personaSrv.toUpper(persona);
		return personaUpper;
	}
	
	/**
	 * PathVariable
	 * localhost:8080/api/persona/4
	 * @param id_variabile numero intero
	 * @return numero intero
	 */
	@GetMapping("/{id_segnaposto}")
	public int getPersonaById(@PathVariable("id_segnaposto") int id_variabile)
	{
		return id_variabile;
	}
	
	/**
	 * RequestParam -> Querystring
	 * https://it.wikipedia.org/wiki/Query_string
	 * localhost:8080/api/persona/param?id_segnaposto=5&nome=fabio
	 * @return int intero
	 */
	@GetMapping(path = "/param")
	public String getPersonaByIdParam(
			@RequestParam("id_segnaposto") int id_variabile, 
			@RequestParam("nome") String nome) {
		return id_variabile + " " + nome;
		
	}
	
	
	
	
	
}
