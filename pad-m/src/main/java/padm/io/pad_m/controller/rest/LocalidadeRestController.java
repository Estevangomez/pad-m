package padm.io.pad_m.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.Localidade;
import padm.io.pad_m.service.LocalidadeService;

@RestController
@RequestMapping("/api/localidades")
public class LocalidadeRestController {
	@Autowired
	LocalidadeService localidadeService;

	@GetMapping
	public ResponseEntity<List<Localidade>> findAll() {
		return ResponseEntity.ok(localidadeService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Localidade> findById(@PathVariable("id") Integer id) {		
		Localidade localidade = localidadeService.findById(id).get();
		return ResponseEntity.ok(localidade);
	}
	

}
