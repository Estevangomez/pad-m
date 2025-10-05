package padm.io.pad_m.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.Orgao;
import padm.io.pad_m.service.OrgaoService;

@RestController
@RequestMapping("/api/orgaos")
public class OrgaoRestController {
	@Autowired
	OrgaoService orgaoService;

	@GetMapping
	public ResponseEntity<List<Orgao>> findAll() {
		return ResponseEntity.ok(orgaoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Orgao> findById(@PathVariable("id") Integer id) {		
		Orgao orgao = orgaoService.findById(id).get();
		return ResponseEntity.ok(orgao);
	}

}
