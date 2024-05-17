package com.generation.es2springdatabase.restcontroller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.es2springdatabase.entity.Macchina;
import com.generation.es2springdatabase.entity.Persona;
import com.generation.es2springdatabase.entity.Scarpe;
import com.generation.es2springdatabase.repository.ScarpeRepository;
import com.generation.es2springdatabase.service.PersonaService;

@RestController
@RequestMapping("/api/scarpe")
public class ScarpeController {

	Logger logger = LoggerFactory.getLogger(ScarpeController.class);
	
	@Autowired
	ScarpeRepository scarpeRepo;
	
	@Autowired
	private PersonaService persService;
	
	
	@PostMapping("/persona/{id-pers}")
	public ResponseEntity<?> aggiungiScarpe(@RequestBody Scarpe scarpe, @PathVariable("id-pers") int idPers)
	{
		try {
			Persona persona = persService.getById(idPers).get();
			//scarpe.setPersone( Arrays.asList(persona)); //NO!
			
			//cerca tutte le scarpe di questa persona
			//aagiungi questa scarpa a questa persona
//			List<Persona> persone = scarpe.getPersone();
//			if(persone == null)
//			{
//				scarpe.setPersone(Arrays.asList(persona));
//			}
//			else {
//				scarpe.getPersone().add(persona);
//			}
			
			scarpeRepo.save(scarpe);
			
			List<Scarpe> scarpeList = persona.getScarpe();
			if(scarpeList == null)
			{
				persona.setScarpe(Arrays.asList(scarpe));
			}
			else {
				persona.getScarpe().add(scarpe);
			}
			persService.addOrUpdate(persona);

			return ResponseEntity.ok(scarpe);
			
		} catch (Exception e) {
	        logger.error("An ERROR Message", e);
	        return ResponseEntity.internalServerError().build();
		}
	}
	
}
