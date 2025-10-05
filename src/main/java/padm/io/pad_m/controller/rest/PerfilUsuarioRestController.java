package padm.io.pad_m.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.PerfilUsuario;
import padm.io.pad_m.service.PerfilUsuarioService;

@RestController
@RequestMapping("/api/perfisUsuarios")
public class PerfilUsuarioRestController {
	@Autowired
	PerfilUsuarioService perfilUsuarioService;

	@GetMapping
	public ResponseEntity<List<PerfilUsuario>> findAll() {
		return ResponseEntity.ok(perfilUsuarioService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PerfilUsuario> findById(@PathVariable("id") Integer id) {
		System.out.println("=======================");
		PerfilUsuario perfilUsuario = perfilUsuarioService.findById(id).get();
		return ResponseEntity.ok(perfilUsuario);
	}

}
