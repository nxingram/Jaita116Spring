package com.generation.es2springdatabase.mvccontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexMvcCtrl {

	@GetMapping
	public String index()
	{
		return "index";
	}
}
