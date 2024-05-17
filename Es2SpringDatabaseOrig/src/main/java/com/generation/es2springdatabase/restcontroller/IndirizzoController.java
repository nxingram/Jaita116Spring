//package com.generation.es2springdatabase.restcontroller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.generation.es2springdatabase.entity.Indirizzo;
//import com.generation.es2springdatabase.entity.Persona;
//import com.generation.es2springdatabase.repository.IndirizzoRepository;
//import com.generation.es2springdatabase.service.PersonaService;
//
//@RestController
//@RequestMapping("api/indirizzo")
//public class IndirizzoController {
//
//	//non fatelo!!
//	@Autowired
//	IndirizzoRepository indirRepo; 
//	@Autowired
//	PersonaService perSrv;
//	
//	@PostMapping("/persona/{id-pers}")
//	public ResponseEntity<?> aggiungiIndirizzo(@RequestBody Indirizzo indirizzo, @PathVariable("id-pers") int idPers ){
//		
//		//dovrei controllare se esiste la persona
////		indirizzo.setPersonaId(idPers);
//		Persona pers = perSrv.getById(idPers).get();
//		indirizzo.setPersona(pers);
//		//salvare
//		indirRepo.save(indirizzo);
//		return ResponseEntity.ok(indirizzo);
//	}
//	
//	@GetMapping("{id-indir}")
//	public ResponseEntity<?> getIndirizzo(@PathVariable("id-indir") long idIndirizzo ){
//		return ResponseEntity.of(indirRepo.findById(idIndirizzo));
//	}
//}
