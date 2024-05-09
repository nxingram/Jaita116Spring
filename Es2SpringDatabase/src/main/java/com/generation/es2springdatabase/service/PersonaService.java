package com.generation.es2springdatabase.service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.es2springdatabase.entity.Persona;
import com.generation.es2springdatabase.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	PersonaRepository personaRepo; 
	
	
	public ArrayList<Persona> getAll(){		
		ArrayList<Persona> persone =   (ArrayList<Persona>) personaRepo.findAll();
		return persone;
	}
}
