package com.generation.es2springdatabase.service;

import java.util.List;
import java.util.Optional;

import com.generation.es2springdatabase.dto.LoginEsito;
import com.generation.es2springdatabase.dto.PersonaDto;
import com.generation.es2springdatabase.entity.Persona;

public interface PersonaService {
	List<Persona> getAll();
	Optional<Persona> getById(int idPersona);
	Persona addOrUpdate(Persona persona);
	boolean addOrUpdateDto(PersonaDto pdto);
	void deleteById(Persona persona);
	Persona findByEmail(String email);
	boolean findByEmailExists(String email);
	LoginEsito login(String email, String password);
}
