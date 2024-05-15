package com.generation.es2springdatabase.repository;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Meta;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.es2springdatabase.dto.PersonaDtoNomeCognome;
import com.generation.es2springdatabase.dto.PersonaView;
import com.generation.es2springdatabase.entity.Persona;

import jakarta.transaction.Transactional;

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
	//JPA method name query
	Persona findByEmail(String email); 
	//mette pippo nel segnaposto di email alla posizione ?1
	// select p from Persona p where p.email = ?1
	
	//JPQL: java persistence query language
	//al posto di ?1 viene sostituito il valore del parametro email
	@Query("select p from Persona p where p.email = ?1")
	Persona findByEmailJPQL(String email);

	//Query nativa: scritta in dialetto mysql
	@Query(value = "select * from persone_new p where p.email = ?1", nativeQuery = true)
	Persona findNyEmailNative(String email);	
	
	Optional<Persona> findByEmailAndPassword(String email, String password);
	
	//Pageable == Limit di MySql
	//Sort == OrderBy del dialetto mysql
	@Query("select p from Persona p where p.cognome like ?1%")
	List<Persona> findByCognomeAndSort(String cognome, Sort sort);
	
	//Senza @Param
	//@Query("select p from Persona p where  and p.email = ?1 and p.password = ?2")
	//Named Parameters
	@Query("select p from Persona p where p.password = :pwd and p.email = :ema")
	Persona findByEmailAndPasswordNamedParam(
			@Param("ema") String email, 
			@Param("pwd") String password);
	
	//Update
	@Transactional
	@Modifying //metodo che esegue delle modifiche
	@Query("update Persona p set p.eta = ?1 where p.email = ?2")
	int updateEta(int eta, String email);
	
	// Delete
	@Meta(comment = "cancella in base all'età")
	@Modifying
	@Query("delete from Persona p where p.eta < ?1")
	void deleteByEta(int eta);

	// Proiezioni - Projections
//	https://docs.spring.io/spring-data/jpa/reference/repositories/projections.html)

	Collection<PersonaView> findByCognome(String cognome);

	@Query("Select new com.generation.es2springdatabase.dto.PersonaDTO(p.nome, p.cognome) from Persona p Where p.email = ?1 And p.password = ?2")
	PersonaDtoNomeCognome findByEmailAndPasswordPoiezione(String email, String password);
	
	
	
		
}
