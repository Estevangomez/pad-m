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

import padm.io.pad_m.domain.TipoProcesso;
import padm.io.pad_m.service.TipoProcessoService;

@RestController
@RequestMapping("/api/tiposProcesso")
public class TipoProcessoRestController {
	@Autowired
	TipoProcessoService tiposProcessoService;

	@GetMapping
	public ResponseEntity<List<TipoProcesso>> findAll() {
		return ResponseEntity.ok(tiposProcessoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoProcesso> findById(@PathVariable("id") Integer id) {			
		return ResponseEntity.ok(tiposProcessoService.findById(id).get());
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Optional<TipoProcesso> tp = tiposProcessoService.findById(id);		    
		tiposProcessoService.delete(tp.get());
		return ResponseEntity.noContent().build();
	}

}
