package com.generation.es2springdatabase.restcontroller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.es2springdatabase.entity.Persona;
import com.generation.es2springdatabase.service.PersonaService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/persona")
public class PersonaController {

	@Autowired
	PersonaService personaService; //ioc + dependency injection
	
	@GetMapping //locahost:8080/api/persona GET
	public List<Persona> getAllPersone(){
		return personaService.getAll();
	}
	
	
	@GetMapping("/{idPercorso}")
	public ResponseEntity<Persona> dammiPersonaConId(@PathVariable("idPercorso") int idPers) {
		Persona persona = personaService.getById(idPers);	
		if(persona == null)
		{
			return new ResponseEntity<Persona>(new Persona(), HttpStatus.NOT_FOUND);
		}else
		{
			return new ResponseEntity<Persona>(persona, HttpStatus.OK);
		}
	}
	
	
}
