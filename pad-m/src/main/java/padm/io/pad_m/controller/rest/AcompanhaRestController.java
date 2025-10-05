package padm.io.pad_m.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.Acompanha;
import padm.io.pad_m.service.AcompanhaService;

@RestController
@RequestMapping("/api/acompanhas")
public class AcompanhaRestController {
	@Autowired
	AcompanhaService acompanhaService;

	@GetMapping
	public ResponseEntity<List<Acompanha>> findAll() {
		return ResponseEntity.ok(acompanhaService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Acompanha> findById(@PathVariable("id") Integer id) {
		System.out.println("=======================");
		Acompanha acompanha = acompanhaService.findById(id).get();
		return ResponseEntity.ok(acompanha);
	}

}
