package padm.io.pad_m.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.Moderador;
import padm.io.pad_m.service.ModeradorService;

@RestController
@RequestMapping("/api/moderadores")
public class ModeradorRestController {
	@Autowired
	ModeradorService moderadorService;

	@GetMapping
	public ResponseEntity<List<Moderador>> findAll() {
		return ResponseEntity.ok(moderadorService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Moderador> findById(@PathVariable("id") Integer id) {
		System.out.println("=======================");
		Moderador moderador = moderadorService.findById(id).get();
		return ResponseEntity.ok(moderador);
	}

}
