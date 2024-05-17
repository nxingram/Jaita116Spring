package com.generation.es2springdatabase.mvccontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class IndexMvcCtrl {

	@GetMapping
	public String index(Model model)
	{
		model.addAttribute("title", "Index");
		return "/index"; //ATTENZIONE! mettere "/" altrimenti non funziona se compilato con jar!
	}
}
