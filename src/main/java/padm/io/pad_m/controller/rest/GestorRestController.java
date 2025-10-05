package padm.io.pad_m.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.Gestor;
import padm.io.pad_m.service.GestorService;

@RestController
@RequestMapping("/api/gestores")
public class GestorRestController {
	@Autowired
	GestorService gestorService;

	@GetMapping
	public ResponseEntity<List<Gestor>> findAll() {
		return ResponseEntity.ok(gestorService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Gestor> findById(@PathVariable("id") Integer id) {
		System.out.println("=======================");
		Gestor gestor = gestorService.findById(id).get();
		return ResponseEntity.ok(gestor);
	}

}
