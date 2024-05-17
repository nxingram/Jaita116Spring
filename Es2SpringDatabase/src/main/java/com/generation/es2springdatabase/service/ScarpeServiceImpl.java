package com.generation.es2springdatabase.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.generation.es2springdatabase.entity.Persona;
import com.generation.es2springdatabase.entity.Scarpe;
import com.generation.es2springdatabase.repository.ScarpeRepository;
import com.generation.es2springdatabase.restcontroller.ScarpeController;

import jakarta.transaction.Transactional;

@Service
public class ScarpeServiceImpl {
	Logger logger = LoggerFactory.getLogger(ScarpeServiceImpl.class);
	
	@Autowired
	ScarpeRepository scarpeRepo;
	
	@Autowired
	private PersonaService persService;
	
	@Transactional(rollbackOn = Exception.class) //transazione su modifiche
	public boolean salvaScarpe(Scarpe scarpe, int idPers) throws Exception {
		//begin transaction
		
		scarpeRepo.save(scarpe);
		logger.info("Salvato scarpe");
		Persona persona = persService.getById(idPers).get();

		
		//this.lanciaEccezione(); 
		//rollback transaction
		
		//cerca tutte le scarpe di questa persona
		//aggiungi questa scarpa a questa persona			
		List<Scarpe> scarpeList = persona.getScarpe();
		if(scarpeList == null)
		{
			persona.setScarpe(Arrays.asList(scarpe));
		}
		else {
			persona.getScarpe().add(scarpe);
		}
		persService.addOrUpdate(persona);
		logger.info("Salvato persona");
		
		//commit transaction
		return true;
	}
	
	public void lanciaEccezione() throws Exception {
		logger.warn("Lancio eccezione");
		throw new Exception("@Transactional");
	}
}
