package com.generation.es2springdatabase.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ProvaMvcCtrl {

	@GetMapping
	public String swagger() {
		return "redirect:/swagger-ui/index.html";
	}
}
