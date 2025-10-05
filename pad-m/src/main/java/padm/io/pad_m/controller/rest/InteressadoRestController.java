package padm.io.pad_m.controller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.Interessado;
import padm.io.pad_m.domain.dto.InteressadoDTO;
import padm.io.pad_m.service.InteressadoService;

@RestController
@RequestMapping("/api/interessados")
public class InteressadoRestController {
	@Autowired
	InteressadoService interessadoService;

	@GetMapping
	public ResponseEntity<List<Interessado>> findAll() {
		return ResponseEntity.ok(interessadoService.findAll());
	}

	@GetMapping("/processo/{idProcesso}")
	public ResponseEntity<List<Interessado>> findAllByIdProcesso(@PathVariable("idProcesso") Integer idProcesso) {
		return ResponseEntity.ok(interessadoService.findAllByIdProcesso(idProcesso));
	}

	@GetMapping("/total/{idUser}")
	public ResponseEntity<Integer> totalInteressadoByidUser(@PathVariable("idUser") Integer idUser) {
		return ResponseEntity.ok(interessadoService.totalInteressadoByidUser(idUser));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Interessado> findById(@PathVariable("id") Integer id) {
		Interessado interessado = interessadoService.findById(id).get();
		return ResponseEntity.ok(interessado);
	}

	@PostMapping("/saveSetorInteressado")
	public ResponseEntity<InteressadoDTO> saveSetorInteressado(InteressadoDTO interessado) {
		interessadoService.saveSetorInteressado(interessado);
		return new ResponseEntity<>(interessado, HttpStatus.CREATED);
	}

	@PostMapping("/saveUsuarioInteressado")
	public ResponseEntity<InteressadoDTO> saveUsuarioInteressado(InteressadoDTO interessado) {
		interessadoService.saveUsuarioInteressado(interessado);
		return new ResponseEntity<>(interessado, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Integer> delete(@PathVariable("id") Integer id) {
		Integer ret = 0;
		Optional<Interessado> interessado = interessadoService.findById(id);
		ret = interessadoService.delete(interessado.get());
		return ResponseEntity.ok(ret);
	}

}
