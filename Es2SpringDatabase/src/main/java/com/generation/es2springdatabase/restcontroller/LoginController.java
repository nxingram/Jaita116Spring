package com.generation.es2springdatabase.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generation.es2springdatabase.dto.LoginDTO;

@RestController
@RequestMapping("api/login")
public class LoginController {

	@PostMapping
	public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password){
		return new ResponseEntity<String>("ciao", HttpStatus.OK);
	}
	
	@PostMapping("/dto")
	public ResponseEntity<LoginDTO> loginDto(@RequestBody LoginDTO login){
//		servicePersona.controllaLoginUtente(login);
		return new ResponseEntity<LoginDTO>(login, HttpStatus.OK);
	}
	
	
}
