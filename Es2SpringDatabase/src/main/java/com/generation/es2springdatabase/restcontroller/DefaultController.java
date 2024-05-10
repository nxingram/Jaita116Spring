package com.generation.es2springdatabase.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DefaultController {

	@GetMapping
	public String rottaBase() {
		return "Es2SpringDatabase";
	}
}
