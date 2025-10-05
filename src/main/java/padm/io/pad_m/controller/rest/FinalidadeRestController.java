package padm.io.pad_m.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.Finalidade;
import padm.io.pad_m.service.FinalidadeService;

@RestController
@RequestMapping("/api/finalidades")
public class FinalidadeRestController {
	@Autowired
	FinalidadeService finalidadeService;

	@GetMapping
	public ResponseEntity<List<Finalidade>> findAll() {
		return ResponseEntity.ok(finalidadeService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Finalidade> findById(@PathVariable("id") Integer id) {
		System.out.println("=======================");
		Finalidade finalidade = finalidadeService.findById(id).get();
		return ResponseEntity.ok(finalidade);
	}

}
