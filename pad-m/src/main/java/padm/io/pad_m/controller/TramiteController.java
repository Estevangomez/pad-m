package padm.io.pad_m.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import padm.io.pad_m.domain.Evento;
import padm.io.pad_m.domain.Processo;
import padm.io.pad_m.domain.Setor;
import padm.io.pad_m.domain.Tramite;
import padm.io.pad_m.security.AuthenticationFacade;
import padm.io.pad_m.service.EventoService;
import padm.io.pad_m.service.ProcessoService;
import padm.io.pad_m.service.SetorService;
import padm.io.pad_m.service.SigiloService;
import padm.io.pad_m.service.TipoEventoService;
import padm.io.pad_m.service.TipoProcessoService;
import padm.io.pad_m.service.TramiteService;
import padm.io.pad_m.service.UsuarioService;

@Controller
@RequestMapping("/tramite")
public class TramiteController {

	DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Autowired
	private ProcessoService processoService; 
	
	@Autowired
	private TipoEventoService tipoEventoService; 	

	@Autowired
	private TramiteService tramiteService;
	
	@Autowired
	private SigiloService sigiloService;
	
	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private SetorService setorService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TipoProcessoService tipoProcessoService;
	
	@Autowired
	AuthenticationFacade session;
	
	@GetMapping
	public ModelAndView findAll() {		
		ModelAndView mv = new ModelAndView("consulta/tramites");
		mv.addObject("tipos", tipoProcessoService.findAll());
		return mv;
	}

	@GetMapping("/new/{idProcesso}")
	public String frmCadastrar(Model model,@PathVariable("idProcesso") Integer idProcesso, @ModelAttribute("tramite") Tramite tramite) {
		
		model.addAttribute("processo", processoService.findById(idProcesso).get());		
		
		model.addAttribute("setores", setorService.findAll());	
		model.addAttribute("usuarios", usuarioService.findAll());	
		model.addAttribute("tramite", tramite);
		return "form/frmTramite";
	}

	@PostMapping("/save")
	public String saveObject(@ModelAttribute("tramite") Tramite tramite, BindingResult result) {
		try {
			Optional<Setor> setor =  setorService.findById(tramite.getSetordestino().getId());
			Evento evento = eventoService.findFirstByProcessoId(tramite.getProcId().getId()); 
			evento.setDatasaida(LocalDateTime.now());
			evento.setDatatermino(LocalDateTime.now());
			eventoService.save(evento);
			
			Optional<Tramite> t = tramiteService.findBySetorDataSaidaProcesso(session.getUsuario().getLotacao_id().getId(),tramite.getProcId().getId());
			if(t.isPresent()){
				t.get().setDatasaida(LocalDateTime.now());
				tramiteService.save(t.get());
			}
			
			
			tramite.setTipo(tramite.getProcId().getTipo().getDescricao());			
			tramite.setSetororigem(session.getUsuario().getLotacao_id()); 
			
			if(tramite.getProcId().getSetorcriadorId().getId() != session.getUsuario().getLotacao_id().getId()){
				tramite.setSetorcriador(tramite.getProcId().getSetorcriadorId());	
			}else{
				tramite.setSetorcriador(session.getUsuario().getLotacao_id());	
			}
		
			tramite.setLocaltramite(session.getUsuario().getLotacao_id().getId());
			
			tramite.setDatachegada(LocalDateTime.now());			
			tramite.setDatasaida(null);
			tramite.setDatacheck(LocalDateTime.now());	
			tramite.setDatavencimentoresposta(LocalDateTime.now().plusDays(tramite.getQtdDiasResposta())); 
			
			tramite.setUserId(session.getUsuario());
			tramite.setUsercriadorId(session.getUsuario().getId());			
			
			tramite.setAtendenteId(null);
			tramite.setModeradorId(null);
			tramite.setGestorId(null);
			
			
			tramite.setTramitacao("Processo: " +tramite.getProcId().getNumanoproc() + " - " + tramite.getProcId().getAssunto() + " Recebido no Setor " + 
					tramite.getSetordestino().getNome() + " Em " + parser.format(LocalDateTime.now()) );			
			
			tramite.setDataarquivamento(null);
			tramite.setDatadesarquivamento(null);
			tramite.setSigiloId(sigiloService.findById(1).get());
			
			tramite.setVisibilidade(tramite.getProcId().getSigiloId().getVisibilidade());
			tramite.setRecebimento(1);
			tramite.setDatarecebimento(LocalDateTime.now());		
				
			tramite.setEspera(1);
			tramite.setDatainicioespera(LocalDateTime.now());
			tramite.setDatafimespera(null);
			
			tramite.setSeq(1);
			tramite.setFlag(1);
			tramite.setPlaced(1);
			tramiteService.save(tramite);
			
			Evento novoEvento = new Evento();	
			novoEvento.setDatachegada(LocalDateTime.now());
			novoEvento.setDataevento(LocalDateTime.now());
			novoEvento.setDatainicio(LocalDateTime.now());
			novoEvento.setProc_id(tramite.getProcId());
			novoEvento.setDoc_id(tramite.getProcId().getDocumento());
			novoEvento.setTipo_id(tipoEventoService.findById(1).get());
			novoEvento.setEvento("Usuario : " + session.getUsuario().getNome() + " Enviou Processo : " + tramite.getProcId().getNumanoproc() + " - " +  tramite.getProcId().getAssunto()
					+ " para o Setor " + setor.get().getNome()  + " Em " + LocalDateTime.now());
			
			eventoService.save(novoEvento);
			Optional<Processo> p = Optional.ofNullable(processoService.findById(tramite.getProcId().getId()).get());
			p.get().setTramitado(1);
			processoService.save(p.get());
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return "redirect:/processos";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView frmEditar(@PathVariable(name = "id") Integer id) {
		ModelAndView model = new ModelAndView("form/frmSetor");
		return model;
	}
	
	
	
	
}
