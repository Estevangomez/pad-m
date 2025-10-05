package padm.io.pad_m.controller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.Atendente;
import padm.io.pad_m.service.AtendenteService;

@RestController
@RequestMapping("/api/atendentes")
public class AtendenteRestController {
	@Autowired
	AtendenteService atendenteService;

	@GetMapping
	public ResponseEntity<List<Atendente>> findAll() {
		return ResponseEntity.ok(atendenteService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Atendente> findById(@PathVariable("id") Integer id) {		
		Atendente atendente = atendenteService.findById(id).get();
		return ResponseEntity.ok(atendente);
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Atendente> findAByIdUsuario(@PathVariable("id") Integer id) {		
		Optional<Atendente> atendente;	
		atendente = atendenteService.findAByIdUsuario(id);	
		if(atendente.isPresent()){
			return ResponseEntity.ok(atendente.get());
		}else{
			return ResponseEntity.ok(new Atendente());
		}
	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Optional<Atendente> user = atendenteService.findById(id);	    
		atendenteService.delete(user.get());
		return ResponseEntity.noContent().build();
	}

}
