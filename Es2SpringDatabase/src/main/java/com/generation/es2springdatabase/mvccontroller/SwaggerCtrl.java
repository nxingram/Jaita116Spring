package com.generation.es2springdatabase.mvccontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SwaggerCtrl {

	@GetMapping //localhost:8080/
	String redirezionaSwagger() {
		return "redirect:/swagger-ui/index.html#";
	} 
	
	
}
