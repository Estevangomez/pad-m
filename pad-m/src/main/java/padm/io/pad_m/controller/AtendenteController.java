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

import padm.io.pad_m.domain.Atendente;
import padm.io.pad_m.security.AuthenticationFacade;
import padm.io.pad_m.service.AtendenteService;
import padm.io.pad_m.service.UsuarioService;

@Controller
@RequestMapping("/atendente")
public class AtendenteController {

	DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Autowired
	private AtendenteService atendenteService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	AuthenticationFacade session;

	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("consulta/atendentes");
		mv.addObject("atendentes", atendenteService.findAll());
		return mv;
	}

	@GetMapping("/new")
	public String frmCadastrar(Model model, @ModelAttribute("atendente") Atendente atendente) {
		model.addAttribute("usuarios", usuarioService.findAllBySetor(session.getUsuario().getLotacao_id().getId()).get());
		model.addAttribute("atendente", atendente);
		return "form/frmAtendente";
	}

	@PostMapping("/save")
	public String saveObject(Model model,@ModelAttribute("atendente") Atendente atendente, BindingResult result) {
		try {			
			Optional<Atendente> a =  atendenteService.findAByIdUsuario(atendente.getUsuario().getId());
			if(a.isEmpty()){ 
				atendente.setServidor(atendente.getUsuario().getServidorId());
				atendente.setSetor(session.getUsuario().getLotacao_id());
				atendente.setDatacriacao(LocalDateTime.now());
				atendenteService.save(atendente);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/atendente";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView frmEditar(@PathVariable(name = "id") Integer id) {
		ModelAndView model = new ModelAndView("form/frmAtendente");
		return model;
	}
}
