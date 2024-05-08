package com.generation.es1spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // controller di tipo REST
@RequestMapping("/api/json") // rotta-action rest api
public class ProvaController {
//RestController rispondere alle ichieste proventi da applicazioni o browser
	
	@GetMapping
	public String getJsonString() {
		return "abc";
	}
}
