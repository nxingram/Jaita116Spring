package com.generation.es2springdatabase.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.es2springdatabase.entity.Persona;

/**
 * Coincide con DAO: Data access object
 * e il package repository coincide con il DAL: data access layer
 * strato(tier) che si occupa della comunicazione con il database
 * 
 * JPA: interfaccia Java Persistence Api
 */
@Repository //opzionale
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

	//Persona findByEmail(String email);
	
	//Firma del metodo dell'interfaccia
	//TipoRitorno   nomeDelMetodo  (parametri 1 o +) (TipoVar nomeVar)
	Persona findByEmail(String email); 
	//mette pippo nel segnaposto di email alla posizione ?1
	// select p from Persona p where p.email = ?1
	
	
	Optional<Persona> findByEmailAndPassword(String email, String password);
	
		
}
