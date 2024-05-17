package com.generation.es2springdatabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.es2springdatabase.entity.Indirizzo;
import com.generation.es2springdatabase.repository.IndirizzoRepository;

@Service
public class IndirizzoServiceImpl {

	@Autowired
	private IndirizzoRepository indirRepo;
	
	public Indirizzo addOrUpdate(Indirizzo indirizzo)
	{
		return indirRepo.save(indirizzo);
	}
}
