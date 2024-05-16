package com.generation.es2springdatabase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.es2springdatabase.entity.Persona;
import com.generation.es2springdatabase.repository.PersonaRepository;

@Service
public class PersonaServiceImplementation implements PersonaService { //Impl = implementazione di una interfaccia

	@Autowired
	PersonaRepository personaRepo;

	@Override
	public List<Persona> getAll() {
		List<Persona> persone = personaRepo.findAll();
		return persone;
	}


	@Override
	public Optional<Persona> getById(int idPersona) {
		Optional<Persona> personaOptional = personaRepo.findById(idPersona);
		return personaOptional;
	}


	@Override
	public Persona addOrUpdate(Persona persona) {
		Persona nuovaPersona = personaRepo.save(persona);
		return nuovaPersona;
	}
	
	@Override
	public void deleteById(Persona persona) {
		personaRepo.delete(persona);		
	}
	
	public void faiQualcosaCheNonSiVedeDaInterfaccia() {
		
	}

	@Override
	public Persona findByEmail(String email) {
		
		return personaRepo.findByEmail(email);
	}


}
