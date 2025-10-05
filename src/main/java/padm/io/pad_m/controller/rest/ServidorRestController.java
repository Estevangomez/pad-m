package padm.io.pad_m.controller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.Servidor;
import padm.io.pad_m.service.ServidorService;

@RestController
@RequestMapping("/api/servidores")
public class ServidorRestController {
	@Autowired
	ServidorService servidorService;

	@GetMapping
	public ResponseEntity<List<Servidor>> findAll() {
		return ResponseEntity.ok(servidorService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Servidor> findById(@PathVariable("id") Integer id) {
		Servidor servidor = servidorService.findById(id).get();
		return ResponseEntity.ok(servidor);
	}


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Optional<Servidor> servidor = servidorService.findById(id);
		servidorService.delete(servidor.get());
		return ResponseEntity.noContent().build();
	}

}
