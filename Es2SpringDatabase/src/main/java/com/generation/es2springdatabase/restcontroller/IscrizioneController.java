package com.generation.es2springdatabase.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.es2springdatabase.entity.Corso;
import com.generation.es2springdatabase.entity.Iscrizione;
import com.generation.es2springdatabase.entity.Persona;
import com.generation.es2springdatabase.repository.CorsoRepository;
import com.generation.es2springdatabase.service.IscrizioneService;
import com.generation.es2springdatabase.service.PersonaService;

@RestController
@RequestMapping("/api/iscrizione")
public class IscrizioneController {
	
	Logger logger = LoggerFactory.getLogger(IscrizioneController.class);
	
	@Autowired
	private IscrizioneService iscrServ;
	@Autowired
	private PersonaService perServ;
	@Autowired
	private CorsoRepository corsoRepo;
	
	@PostMapping("/persona/{id-pers}/corso/{id-cor}")
	public ResponseEntity<?> aggiungiIscrizione(
			@RequestBody Iscrizione iscrizione,
			@PathVariable("id-pers") int idPers,
			@PathVariable("id-cor") long idCor			
			){
		
		try {
			//cerca persona e corso su db
			Persona persona = perServ.getById(idPers).get();
			Corso corso = corsoRepo.findById(idCor).get();
			
			//imposto la relazione chiavi esterne
			iscrizione.setPersona(persona);
			iscrizione.setCorso(corso);
			
			//salvo
			iscrServ.addOrUpdate(iscrizione); //SALVA!!
			
			return ResponseEntity.ok(iscrizione);			
		} catch (Exception e) {
	        logger.error("An ERROR Message", e);
	        return ResponseEntity.internalServerError().build();
		}
		
	}
	
	
}
