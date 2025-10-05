package padm.io.pad_m.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.UnidadeLotacao;
import padm.io.pad_m.service.UnidadeLotacaoService;

@RestController
@RequestMapping("/api/unidades")
public class UnidadeLotacaoRestController {
	@Autowired
	UnidadeLotacaoService unidadeService;

	@GetMapping
	public ResponseEntity<List<UnidadeLotacao>> findAll() {
		return ResponseEntity.ok(unidadeService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<UnidadeLotacao> findById(@PathVariable("id") Integer id) {
		UnidadeLotacao und = unidadeService.findById(id).get();
		return ResponseEntity.ok(und);
	}

	@GetMapping("/orgao/{idOrgao}/localidade/{idLocalidade}")
	public ResponseEntity<List<UnidadeLotacao>> findAllByIdOrgaoAndIdLocalidade(
			@PathVariable("idOrgao") Integer idOrgao, @PathVariable("idLocalidade") Integer idLocalidade) {
		return ResponseEntity.ok(unidadeService.findAllByIdOrgaoAndIdLocalidade(idOrgao, idLocalidade));
	}

}
