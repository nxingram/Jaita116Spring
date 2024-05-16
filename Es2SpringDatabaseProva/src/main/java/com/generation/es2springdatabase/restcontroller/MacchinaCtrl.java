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

import com.generation.es2springdatabase.entity.Macchina;
import com.generation.es2springdatabase.entity.Persona;
import com.generation.es2springdatabase.service.MacchinaService;
import com.generation.es2springdatabase.service.PersonaService;

@RestController
@RequestMapping("api/macchina")
public class MacchinaCtrl {
	Logger logger = LoggerFactory.getLogger(MacchinaCtrl.class);
	
	@Autowired
	PersonaService persSrv;
	
	@Autowired 
	MacchinaService macServ;
	
	@PostMapping("/persona/{id-persona}")
	public ResponseEntity<?> aggiungiMacchina(@RequestBody Macchina macchina, @PathVariable("id-persona") int idPersona) {
		try {
			Optional<Persona> optPpers = persSrv.getById(idPersona);
			if(!optPpers.isEmpty())
			{
				macchina.setPersona(optPpers.get());
				macServ.save(macchina);
				return ResponseEntity.ok().body(macchina);
			}else
			{			
				return ResponseEntity.badRequest().body(macchina);
			}
			
		} catch (Exception e) {
			macchina.setMacchinaId(0);
//			https://www.baeldung.com/spring-boot-logging
//	        logger.trace("A TRACE Message");
//	        logger.debug("A DEBUG Message");
	        logger.info("An INFO Message");
	        logger.warn("A WARN Message");
	        logger.error("An ERROR Message", e);
			return ResponseEntity.internalServerError().body(macchina);
		}
		

	}

}
