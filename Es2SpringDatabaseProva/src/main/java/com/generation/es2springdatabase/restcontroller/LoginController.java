package com.generation.es2springdatabase.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generation.es2springdatabase.dto.LoginDTO;
import com.generation.es2springdatabase.dto.LoginEsito;
import com.generation.es2springdatabase.entity.Persona;
import com.generation.es2springdatabase.service.PersonaService;

@RestController
@RequestMapping("api/login")
public class LoginController {

	@Autowired
	PersonaService personaService;
	
	@PostMapping
	public ResponseEntity<String> login(
			@RequestParam String email, 
			@RequestParam String password
			){

		return new ResponseEntity<String>(personaService.findByEmail(email).getNome() , HttpStatus.OK);
	}
	
	@PostMapping("/dto")
	public ResponseEntity<Persona> loginDto(@RequestBody LoginDTO login){
		LoginEsito esito =  personaService.login(login.getEmail(), login.getPassword());
		if(esito.isEsitoLogin())
		{
			return new ResponseEntity<Persona>(esito.getPersona(), HttpStatus.OK);		
		}
		else
		{
			return new ResponseEntity<Persona>(esito.getPersona(), HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
}
