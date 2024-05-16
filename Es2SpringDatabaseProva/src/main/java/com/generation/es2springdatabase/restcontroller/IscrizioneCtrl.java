package com.generation.es2springdatabase.restcontroller;

import java.util.Optional;

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
@RequestMapping("api/iscrizione")
public class IscrizioneCtrl {

	Logger logger = LoggerFactory.getLogger(IscrizioneCtrl.class);
	
	@Autowired
	PersonaService perServ;
	@Autowired
	IscrizioneService iscServ;
	@Autowired
	CorsoRepository corsoRepo;
	
	
	@PostMapping("persona/{p-id}/corso/{c-id}")
	public ResponseEntity<?>  nuovaIscrizione(@PathVariable("p-id") int pId, @PathVariable("c-id") long cId, @RequestBody Iscrizione iscrizione)
	{
		try {
			Optional<Persona> optPers = perServ.getById(pId);
			Optional<Corso> optCorso = corsoRepo.findById(cId);
			if(!optPers.isEmpty() && !optCorso.isEmpty())
			{
				iscrizione.setPersona(optPers.get());
				iscrizione.setCorso(optCorso.get());
				iscServ.save(iscrizione);
				return ResponseEntity.ok().body(iscrizione);
			}
			
			iscrizione.setIscrizioneId(0);
			return ResponseEntity.badRequest().body(iscrizione);
			
			
		} catch (Exception e) {
			iscrizione.setIscrizioneId(0);
	        logger.error("An ERROR Message", e);
			return ResponseEntity.internalServerError().body(iscrizione);
		}
	}
}
