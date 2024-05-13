package com.generation.es2springdatabase.repository;


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

		
}
