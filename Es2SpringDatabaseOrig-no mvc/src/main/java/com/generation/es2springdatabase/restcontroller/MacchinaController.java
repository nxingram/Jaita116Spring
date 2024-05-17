package com.generation.es2springdatabase.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.es2springdatabase.entity.Macchina;
import com.generation.es2springdatabase.entity.Persona;
import com.generation.es2springdatabase.service.MacchinaServiceImpl;
import com.generation.es2springdatabase.service.PersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/macchina")
public class MacchinaController {

	//
	private static final Logger logger = LoggerFactory.getLogger(MacchinaController.class);
	
	@Autowired
	private PersonaService persService;
	
	@Autowired
	private MacchinaServiceImpl macServ;
	
	@PostMapping("/persona/{id-pers}")
	public ResponseEntity<?> aggiungimacchina(@RequestBody Macchina macchina, @PathVariable("id-pers") int idPers)
	{
		try {
			Persona persona = persService.getById(idPers).get();
			macchina.setPersona(persona);
			macServ.addOrUpdate(macchina);//SALVA!!!
			return ResponseEntity.ok(macchina);
			
		} catch (Exception e) {
//			https://www.baeldung.com/spring-boot-logging
//	        logger.trace("A TRACE Message");
//	        logger.debug("A DEBUG Message");
	        logger.info("An INFO Message");
	        logger.warn("A WARN Message");
	        logger.error("An ERROR Message", e);
	        return ResponseEntity.internalServerError().build();
		}
	}
	
	
}
