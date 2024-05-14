package com.generation.es2springdatabase.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@GetMapping //locahost:8080/api/persona GET:prendere/cercare - solo lettura
	public List<Persona> getAllPersone(){
		return personaService.getAll();
	}
	
	//locahost:8080/api/persona/1 GET:prendere/cercare- solo lettura
	@GetMapping("/{id-persona}")
	public ResponseEntity<Persona> dammiPersonaConId(@PathVariable("id-persona") int idPers) {
//		Persona persona = personaService.getById(idPers);	
//		if(persona == null)
//		{
//			return new ResponseEntity<Persona>(new Persona(), HttpStatus.NOT_FOUND);
//		}else
//		{
//			return new ResponseEntity<Persona>(persona, HttpStatus.OK);
//		}		
		
		Optional<Persona> optional = personaService.getById(idPers);
		if(optional.isEmpty())
		{
			return new ResponseEntity<Persona>(new Persona(), HttpStatus.NOT_FOUND);
			
		}else {
			return new ResponseEntity<Persona>(optional.get(), HttpStatus.OK);
		}
	}
	
	//locahost:8080/api/persona POST: aggiungere - modifica
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
	
	//locahost:8080/api/persona PUT: modificare  - modifica
	@PutMapping //aggiorna
	public ResponseEntity<?> aggiornaPersona(@RequestBody PersonaDto personaDto){
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
	
	//locahost:8080/api/persona/1 DELETE :cancellare  - modifica
	@DeleteMapping("/{id-persona}")
	public ResponseEntity<Persona> cancellaPersona(@PathVariable("id-persona") int idPers)
	{
		try {
			//1456
			Optional<Persona> optional = personaService.getById(idPers);
			if(optional.isEmpty())
			{
				return new ResponseEntity<Persona>(new Persona(), HttpStatus.NOT_FOUND);
				
			}else {
				personaService.deleteById(optional.get());
				return new ResponseEntity<Persona>(optional.get(), HttpStatus.OK);
			}
			
		} catch (Exception e) {
//			return (ResponseEntity<?>) ResponseEntity.internalServerError();
			return new ResponseEntity<Persona>(new Persona(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	
	
}
