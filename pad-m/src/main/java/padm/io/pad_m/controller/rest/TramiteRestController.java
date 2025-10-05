package padm.io.pad_m.controller.rest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.Evento;
import padm.io.pad_m.domain.Processo;
import padm.io.pad_m.domain.Tramite;
import padm.io.pad_m.domain.Usuario;
import padm.io.pad_m.domain.dto.ResultDTO;
import padm.io.pad_m.security.AuthenticationFacade;
import padm.io.pad_m.service.EventoService;
import padm.io.pad_m.service.ProcessoService;
import padm.io.pad_m.service.TipoEventoService;
import padm.io.pad_m.service.TramiteService;
import padm.io.pad_m.service.UsuarioService;

@RestController
@RequestMapping("/api/tramites")
public class TramiteRestController {
	DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Autowired
	TramiteService tramiteService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ProcessoService processoService;
	
	@Autowired
	AuthenticationFacade session;
	

	@Autowired
	EventoService eventoService;
	
	@Autowired
	TipoEventoService tipoEventoService; 

	@GetMapping
	public ResponseEntity<List<Tramite>> findAll() {
		return ResponseEntity.ok(tramiteService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tramite> findById(@PathVariable("id") Integer id) {	
		Tramite tramite = tramiteService.findById(id).get();
		return ResponseEntity.ok(tramite);
	}
	
	@GetMapping("/processo/{idProcesso}")
	public ResponseEntity<Tramite> findFirstByProcessoId(@PathVariable("idProcesso") Integer idProcesso) {	
		Tramite tramite = tramiteService.findFirstByProcId(idProcesso);
		return ResponseEntity.ok(tramite);
	}
	
	
	@GetMapping("/processo/all/{idProcesso}")
	public ResponseEntity<List<Tramite>> findAllByIdProcesso(@PathVariable("idProcesso") Integer idProcesso) {	
		List<Tramite> tramites = tramiteService.findAllByIdProcesso(idProcesso);
		return ResponseEntity.ok(tramites);
	}
	
	
	@GetMapping("/processo/all/vencidosBySetor/{idSetor}")
	public ResponseEntity<List<Tramite>> findAllTramitesVencidos(@PathVariable("idSetor") Integer idSetor) {	
		List<Tramite> tramites = tramiteService.findAllTramitesVencidos(idSetor);
		return ResponseEntity.ok(tramites);
	}
	
	
	@GetMapping("/processo/id/{idProcesso}/responsavel/{idResponsavel}")
	public ResponseEntity<ResultDTO> findLastTramiteByProcesso(@PathVariable("idProcesso") Integer idProcesso, @PathVariable("idResponsavel") Integer idResponsavel) {		
		ResultDTO result = new ResultDTO();
		try {
			Tramite tramite = tramiteService.findFirstByProcId(idProcesso);	
			Usuario user = usuarioService.findById(idResponsavel).get();
			tramite.setResponsavelId(user);
			tramiteService.save(tramite);
			
			Evento novoEvento = new Evento();				
			novoEvento.setProc_id(tramite.getProcId());	
			novoEvento.setDataevento(LocalDateTime.now());
			novoEvento.setTipo_id(tipoEventoService.findById(3).get());
			String dataFormatada = LocalDateTime.now().format(parser);
			novoEvento.setEvento("Usuario : " + user.getNome() + " Foi Indicado para atender o  Processo : " + tramite.getProcId().getNumanoproc() + " - " +  tramite.getProcId().getAssunto()
					+ " no Setor " + session.getUsuario().getLotacao_id().getNome() + " Em " + dataFormatada);
			
			eventoService.save(novoEvento);
			
			result.setRet(1);
			result.setMensagem("Realizado Com Sucesso");
			result.setType("success");
		} catch (Exception e) {		
			e.printStackTrace();
			result.setRet(0);
			result.setMensagem("Ocorreu um Erro");
			result.setType("error");
		}
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/processo/arquivar/{idProcesso}/arquivado/{arquivado}")
	public ResponseEntity<ResultDTO> arquivarProcesso(@PathVariable("idProcesso") Integer idProcesso, @PathVariable("arquivado") Integer arquivado) {		
		ResultDTO result = new ResultDTO();
		try {
			
			Optional<Processo> p =  processoService.findById(idProcesso);
			Tramite tramite = tramiteService.findFirstByProcId(idProcesso);
			String situacao = "";
			if(arquivado == 1){
				p.get().setArquivado(0);
				tramite.setDatadesarquivamento(LocalDateTime.now());
				situacao = "Desarquivou";
			}else{
				p.get().setArquivado(1);
				tramite.setDataarquivamento(LocalDateTime.now());		
				situacao = "Arquivou";
			}
				
			
			processoService.save(p.get());				
			tramiteService.save(tramite);
			
			Evento novoEvento = new Evento();				
			novoEvento.setProc_id(tramite.getProcId());	
			novoEvento.setDataevento(LocalDateTime.now());
			novoEvento.setTipo_id(tipoEventoService.findById(8).get());
			String dataFormatada = LocalDateTime.now().format(parser);
			novoEvento.setEvento("Usuario : " + session.getUsuario().getNome() + "   " +  situacao + " o  Processo : " + tramite.getProcId().getNumanoproc() + " - " +  tramite.getProcId().getAssunto()
					+ " no Setor " + session.getUsuario().getLotacao_id().getNome() + " Em " + dataFormatada );
			
			eventoService.save(novoEvento);
			
			result.setRet(1);
			result.setMensagem("Realizado Com Sucesso");
			result.setType("success");
		} catch (Exception e) {		
			e.printStackTrace();
			result.setRet(0);
			result.setMensagem("Ocorreu um Erro");
			result.setType("error");
		}
		
		return ResponseEntity.ok(result);
	}
	

}
