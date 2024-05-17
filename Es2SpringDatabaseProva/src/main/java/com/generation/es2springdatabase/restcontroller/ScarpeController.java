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

import com.generation.es2springdatabase.entity.Scarpe;
import com.generation.es2springdatabase.service.ScarpeServiceImpl;

@RestController
@RequestMapping("/api/scarpe")
public class ScarpeController {

	Logger logger = LoggerFactory.getLogger(ScarpeController.class);
	
	@Autowired
	private ScarpeServiceImpl scarpeSrv;	
	
	@PostMapping("/persona/{id-pers}")
	public ResponseEntity<?> aggiungiScarpe(@RequestBody Scarpe scarpe, @PathVariable("id-pers") int idPers)
	{
		try {
			boolean esitoPositivo = scarpeSrv.salvaScarpe(scarpe, idPers);
			if(esitoPositivo)
			{
				return ResponseEntity.ok(scarpe);				
			}
			else
			{
				return ResponseEntity.badRequest().body(scarpe);
			}
			
		} catch (Exception e) {
	        logger.error("An ERROR Message", e);
	        return ResponseEntity.internalServerError().build();
		}
	}
	
}
