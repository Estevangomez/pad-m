package padm.io.pad_m.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.Sigilo;
import padm.io.pad_m.service.SigiloService;

@RestController
@RequestMapping("/api/sigilos")
public class SigiloRestController {
	@Autowired
	SigiloService sigiloService;

	@GetMapping
	public ResponseEntity<List<Sigilo>> findAll() {
		return ResponseEntity.ok(sigiloService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Sigilo> findById(@PathVariable("id") Integer id) {
		System.out.println("=======================");
		Sigilo sigilo = sigiloService.findById(id).get();
		return ResponseEntity.ok(sigilo);
	}

}
