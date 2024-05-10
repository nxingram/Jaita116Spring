package com.generation.es2springdatabase.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.es2springdatabase.entity.Persona;
import com.generation.es2springdatabase.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	PersonaRepository personaRepo; 
	
	
	public List<Persona> getAll(){		
		List<Persona> persone = personaRepo.findAll();
		return persone;
	}
	
	public Persona getById(int idPersona) {
		try {
			//Optional è la promessa di java
			Optional<Persona> personaOptional = personaRepo.findById(idPersona);
			
			if(personaOptional.isEmpty())
			{
				//return new Persona();	
				return null;
			}
			else			
			{
				return personaOptional.get();				
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return new Persona();
		
	}
}
