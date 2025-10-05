package padm.io.pad_m.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.Classif;
import padm.io.pad_m.service.ClassifService;

@RestController
@RequestMapping("/api/classifs")
public class ClassifRestController {
	@Autowired
	ClassifService classifService;

	@GetMapping
	public ResponseEntity<List<Classif>> findAll() {
		return ResponseEntity.ok(classifService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Classif> findById(@PathVariable("id") Integer id) {
		System.out.println("=======================");
		Classif classif = classifService.findById(id).get();
		return ResponseEntity.ok(classif);
	}

}
