package padm.io.pad_m.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.TipoDoc;
import padm.io.pad_m.service.TipoDocService;

@RestController
@RequestMapping("/api/tiposDocs")
public class TipoDocRestController {
	@Autowired
	TipoDocService tipoDocService;

	@GetMapping
	public ResponseEntity<List<TipoDoc>> findAll() {
		return ResponseEntity.ok(tipoDocService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoDoc> findById(@PathVariable("id") Integer id) {
		System.out.println("=======================");
		TipoDoc tipoDoc = tipoDocService.findById(id).get();
		return ResponseEntity.ok(tipoDoc);
	}

}
