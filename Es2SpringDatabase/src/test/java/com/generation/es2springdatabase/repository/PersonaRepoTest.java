package com.generation.es2springdatabase.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.generation.es2springdatabase.entity.Persona;

import jakarta.transaction.Transactional;

@SpringBootTest
public class PersonaRepoTest {
	
	@Autowired
	PersonaRepository personaRepo;
	
	@Test
	void provaRepoSort()
	{
		List<Persona> persone = personaRepo.findByCognomeAndSort("ros", Sort.by("nome"));
	}
	
	@Test 
//	@Transactional
	void provaEmail()
	{		
//		Persona trovata = personaRepo.findByEmail("a@a.it");
//		assertEquals("a@a.it", trovata.getEmail());
//		
//		Persona trovata2 = personaRepo.findByEmailAndPasswordNamedParam("a@a.it","1234");
//		assertEquals("1234", trovata2.getPassword());
		
		try {
			int righeModificate = personaRepo.updateEta(27, "q@q.it");
			//assertEquals(1, righeModificate);
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
}
