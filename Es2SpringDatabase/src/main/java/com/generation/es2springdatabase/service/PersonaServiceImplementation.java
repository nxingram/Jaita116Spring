package com.generation.es2springdatabase.service;

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

	public List<Persona> getAll() {
		List<Persona> persone = personaRepo.findAll();
		return persone;
	}

	public Optional<Persona> getById(int idPersona) {
		Optional<Persona> personaOptional = personaRepo.findById(idPersona);
		return personaOptional;
	}

	public Persona addOrUpdate(Persona persona) {
		Persona nuovaPersona = personaRepo.save(persona);
		return nuovaPersona;
	}

	public void deleteById(Persona persona) {
		personaRepo.delete(persona);		
	}


}
