package padm.io.pad_m.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.Setor;
import padm.io.pad_m.service.SetorService;

@RestController
@RequestMapping("/api/setores")
public class SetorRestController {
	@Autowired
	SetorService setorService;

	@GetMapping
	public ResponseEntity<List<Setor>> findAll() {
		return ResponseEntity.ok(setorService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Setor> findById(@PathVariable("id") Integer id) {		
		Setor setor = setorService.findById(id).get();
		return ResponseEntity.ok(setor);
	}
	
	/*
		@GetMapping("/orgao/{idOrgao}/localidade/{idLocalidade}/unidade/{idUnidade}")
		public ResponseEntity<List<Setor>> findByOrgaoLocalidadeUnidade(@PathVariable("idOrgao") Integer idOrgao, @PathVariable("idLocalidade") Integer idLocalidade, 
				 @PathVariable("idUnidade") Integer idUnidade) {				
			return ResponseEntity.ok( setorService.findAllByIdOrgaoAndIdLocalidadeAndUnidade(idOrgao,idLocalidade,idUnidade));
		}
	 */
}
