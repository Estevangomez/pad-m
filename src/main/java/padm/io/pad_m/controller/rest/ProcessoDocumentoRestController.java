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

import padm.io.pad_m.domain.ProcessoDocs;
import padm.io.pad_m.domain.dto.ProcessoDocumentoDTO;
import padm.io.pad_m.security.AuthenticationFacade;
import padm.io.pad_m.service.AssinadorService;
import padm.io.pad_m.service.ProcessoDocsService;

@RestController
@RequestMapping("/api/processosDocumentos")
public class ProcessoDocumentoRestController {
	
	@Autowired
	ProcessoDocsService processoDocsService;	
	
	@Autowired
	AssinadorService assinadorService;	
	
	@Autowired
	AuthenticationFacade session;
	
	@PostMapping("/save")
    public ResponseEntity<ProcessoDocumentoDTO> saveProcessoDocs(ProcessoDocumentoDTO processoDocs) {	
		processoDocs.setIdUsuario( session.getUsuario().getId());
		processoDocsService.save(processoDocs);
        return new ResponseEntity<>(processoDocs, HttpStatus.CREATED);
    }
	
	
	@GetMapping("/isAssinado/documento/{idDoc}")
	public Integer isAssinado(@PathVariable("idDoc") Integer idDoc) {	
		Integer ret = assinadorService.findByUserAndDoc(session.getUsuario().getId(), idDoc);
		return ret;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Integer> delete(@PathVariable("id") Integer id) {
		Integer ret = 0;
		Optional<ProcessoDocs> pdocs = processoDocsService.findById(id);    
		ret = processoDocsService.delete(pdocs.get());
		return ResponseEntity.ok(ret);
	}
	
	@GetMapping("/getAllByProcessos/{idProcesso}")
	public ResponseEntity<List<ProcessoDocs>> getAllByProcessos(@PathVariable("idProcesso") Integer idProcesso) {		
		return ResponseEntity.ok(processoDocsService.findAllByProcesso(idProcesso));
	}
	

}
