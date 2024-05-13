package com.generation.es2springdatabase.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.es2springdatabase.dto.PersonaDto;
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
	
	
	@GetMapping("/{id-persona}")
	public ResponseEntity<Persona> dammiPersonaConId(@PathVariable("id-persona") int idPers) {
		Persona persona = personaService.getById(idPers);	
		if(persona == null)
		{
			return new ResponseEntity<Persona>(new Persona(), HttpStatus.NOT_FOUND);
		}else
		{
			return new ResponseEntity<Persona>(persona, HttpStatus.OK);
		}
	}
	
	@PostMapping //? = Jolly
	public ResponseEntity<?> aggiungiPersona(@RequestBody PersonaDto personaDto){
		Persona pers = new Persona(
				personaDto.getNome(),
				personaDto.getCognome(),
				personaDto.getEta(),
				personaDto.getStipendio()
				);		
		
		Persona personaNew = personaService.addOrUpdate(pers);
		return new ResponseEntity<Persona>(personaNew, HttpStatus.OK);	
		
	}
	
	@PutMapping //aggiorna
	public ResponseEntity<?> aggiornPersona(@RequestBody PersonaDto personaDto){
		Persona pers = new Persona(
				personaDto.getPersonaId(), //persona_id mysql per aggioranre la riga
				personaDto.getNome(),
				personaDto.getCognome(),
				personaDto.getEta(),
				personaDto.getStipendio()
				);		
		
		Persona personaNew = personaService.addOrUpdate(pers);
		return new ResponseEntity<Persona>(personaNew, HttpStatus.OK);	
		
	}
	
	
	
	
	
}
