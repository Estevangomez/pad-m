package padm.io.pad_m.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.Evento;
import padm.io.pad_m.service.EventoService;

@RestController
@RequestMapping("/api/eventos")
public class EventoRestController {
	@Autowired
	EventoService eventoService;

	@GetMapping
	public ResponseEntity<List<Evento>> findAll() {
		return ResponseEntity.ok(eventoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Evento> findById(@PathVariable("id") Integer id) {		
		Evento evento = eventoService.findById(id).get();
		return ResponseEntity.ok(evento);
	}
	
	@GetMapping("/processo/{idProcesso}")
	public ResponseEntity<List<Evento>> idProcesso(@PathVariable("idProcesso") Integer idProcesso) {		
		List<Evento> evento = eventoService.findAllByIdProcesso(idProcesso).get();
		return ResponseEntity.ok(evento);
	}
	
	

}
