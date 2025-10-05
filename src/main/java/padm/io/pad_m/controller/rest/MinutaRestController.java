package padm.io.pad_m.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.Minuta;
import padm.io.pad_m.service.MinutaService;

@RestController
@RequestMapping("/api/minutas")
public class MinutaRestController {
	@Autowired
	MinutaService minutaService;

	@GetMapping
	public ResponseEntity<List<Minuta>> findAll() {
		return ResponseEntity.ok(minutaService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Minuta> findById(@PathVariable("id") Integer id) {
		System.out.println("=======================");
		Minuta minuta = minutaService.findById(id).get();
		return ResponseEntity.ok(minuta);
	}

}
