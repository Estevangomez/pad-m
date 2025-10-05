package padm.io.pad_m.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.Fase;
import padm.io.pad_m.service.FaseService;

@RestController
@RequestMapping("/api/fases")
public class FaseRestController {
	@Autowired
	FaseService faseService;

	@GetMapping
	public ResponseEntity<List<Fase>> findAll() {
		return ResponseEntity.ok(faseService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Fase> findById(@PathVariable("id") Integer id) {
		System.out.println("=======================");
		Fase fase = faseService.findById(id).get();
		return ResponseEntity.ok(fase);
	}

}
