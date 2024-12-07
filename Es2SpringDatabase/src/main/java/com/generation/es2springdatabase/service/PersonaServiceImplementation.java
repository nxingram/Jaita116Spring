package com.generation.es2springdatabase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.es2springdatabase.dto.LoginEsito;
import com.generation.es2springdatabase.dto.PersonaDto;
import com.generation.es2springdatabase.entity.Persona;
import com.generation.es2springdatabase.repository.PersonaRepository;

import jakarta.transaction.Transactional;

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
		//dovrei controllare l'email che non sia duplicata
		
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
//		return personaRepo.findByEmail(email);
//		return personaRepo.findByEmailJPQL(email);
		return personaRepo.findNyEmailNative(email);
		
	}


	@Override
	public LoginEsito login(String email, String password) {
		Optional<Persona> personaOptional = personaRepo.findByEmailAndPassword(email, password);
		LoginEsito esito = new LoginEsito();
		if(personaOptional.isEmpty())
		{
			esito.setEsitoLogin(false);
			esito.setPersona(new Persona());
		}
		else {	
			esito.setEsitoLogin(true);
			esito.setPersona(personaOptional.get());
		}
		
		return esito;
		
	}


	@Override
	public boolean findByEmailExists(String email) {
		Persona persona = this.findByEmail(email);
		if(persona == null)
		{
			return false;
		}
		else
		{
			return true;			
		}
	}


	@Override
	@Transactional(rollbackOn = Exception.class)
	public boolean addOrUpdateDto(PersonaDto pdto) {
		Optional<Persona> opt = personaRepo.findById(pdto.getPersonaId());
		if(opt.isEmpty())
		{
			Persona p =  new Persona();
			p.setNome(pdto.getNome());
			p.setCognome(pdto.getCognome());
			p.setEta(pdto.getEta());
			p.setNome(pdto.getNome());
			p.setStipendio(pdto.getStipendio());
			p.setEmail(pdto.getEmail());
			
			personaRepo.save(p);
			return true;
		}
		else
		{
			Persona pers = opt.get();
			pers.setNome(pdto.getNome());
			pers.setCognome(pdto.getCognome());
			pers.setEta(pdto.getEta());
			pers.setNome(pdto.getNome());
			pers.setStipendio(pdto.getStipendio());
			pers.setEmail(pdto.getEmail());
			
			
			
			personaRepo.save(pers);
			return true;			
		}
	}
	
	


}
