package com.generation.es2springdatabase.mvccontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.es2springdatabase.dto.PersonaDto;
import com.generation.es2springdatabase.entity.Persona;
import com.generation.es2springdatabase.service.PersonaService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/persona")
public class PersonaControllerMvc {

	@Autowired 
	PersonaService persSrv;
	
	@GetMapping
	public String elencoPersone(Model model) {
		List<Persona> persone = persSrv.getAll();
		model.addAttribute("listaPersone", persone);
		//persona-elenco.html Thymeleaf
		return "/persona-elenco"; //ATTENZIONE! mettere "/" iniziale altrimenti non funziona se compilato con jar!
	}
	
	// New persona form: riuso stesso di update form
	@GetMapping("/form") // metodo get, rotta: /persona/addform
	public String addForm(Model model) {
		
		// aggiungo persona vuota
		// viene bindato(legato) ai campi del form
		model.addAttribute("persona", new Persona());
		
		return "/persona-form";//ATTENZIONE! mettere "/" iniziale altrimenti non funziona se compilato con jar!
	}
	
	// Aggiorna persona form
	@GetMapping("/{id}") // metodo get, rotta: /persona/{id}
	public String updForm(@PathVariable("id") int id, Model model) { // ("id") in pathVariable si può omettere se ha lo stesso nome presente nella rotta
		// cerco la persona da modificare
		Optional<Persona> persOpt = persSrv.getById(id);
		
		// se l'id non è presente su db, redireziono sulla lista persone
		if(persOpt.isEmpty())
			return "redirect:/persona";
		
		// lo aggiungo al model
		model.addAttribute("persona", persOpt.get()); 
		
		// inoltro i dati alla pagina thymeleaf persona-form.html
		return "/persona-form";	//ATTENZIONE! mettere "/" iniziale altrimenti non funziona se compilato con jar!
	}
	
	
	// Salva: sia nuova persona sia aggiorna persona
	@PostMapping("/save/{id-pers}") // method:post, rotta: /persona/save
	public String savePersona(PersonaDto pDto, @PathVariable("id-pers") int persId) {
		try {
			pDto.setPersonaId(persId);
			// salva persona 
			persSrv.addOrUpdateDto(pDto);
			
			// redireziono su altro metodo del controller
			// in questo caso rimando alla lista delle persone
			return "redirect:/persona"; 
		} catch (Exception e) {
			return "redirect:/persona"; //pagina errore?
		}

	}
	

	@GetMapping("/delete/{id}") // metodo get, rotta: /mvc/delete/{id}
	public String delPersona(@PathVariable("id") int id){// ("id") in pathVariable si può omettere se ha lo stesso nome presente nella rotta
		
		// cerco la persona da cancellare
		Optional<Persona> optPers = persSrv.getById(id);
		
		// se l'id non è presente su db, redireziono sulla lista persone
		if(optPers.isEmpty())
			return "redirect:/persona";
		
		// cancello persona
		persSrv.deleteById(optPers.get());//nomeMetodoSbagliato! non è by id ma tutto l'oggetto
		
		return "/redirect:/persona";//ATTENZIONE! mettere "/" iniziale altrimenti non funziona se compilato con jar!
	}
}
